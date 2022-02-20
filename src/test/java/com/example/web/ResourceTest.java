package com.example.web;

import com.example.web.data.dto.request.PaginationRequestDTO;
import com.example.web.data.dto.request.ResourceDTO;
import com.example.web.data.dto.response.PaginationResponseDTO;
import com.example.web.data.dto.response.resource.ResourceDetailDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.entity.ResourceEntity;
import com.example.web.data.mapper.ResourceMapper;
import com.example.web.exception.custom.NotFoundException;
import com.example.web.repository.resource.ResourceRepository;
import com.example.web.service.ExampleService;
import com.example.web.stub.DTOStub;
import com.example.web.stub.EntitySub;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ResourceTest {
	@Mock
	ResourceRepository resourceRepository;

	@InjectMocks
	ExampleService exampleService;

	@Order(1)
	@DisplayName("1. 리소스 생성 성공")
	@Test
	public void succeededToCreateResource() {
		// Given
		ResourceDTO resourceDTO = DTOStub.getResource();
		ResourceEntity expectedResourceEntity = EntitySub.getResource();
		ResourceDetailDTO expectedResponse = ResourceMapper.entityToResourceDetailDto(expectedResourceEntity);

		// When
		when(resourceRepository.save(any(ResourceEntity.class))).thenReturn(expectedResourceEntity);

		// Then
		ResourceDetailDTO response = exampleService.createResource(resourceDTO);
		Assert.assertEquals(expectedResponse, response);
	}

	@Order(2)
	@DisplayName("2. 리소스 조회 성공")
	@Test
	public void succeededToRetrieveResource() {
		// Given
		int resourceId = EntitySub.getResource().getId();
		ResourceEntity expectedResourceEntity = EntitySub.getResource();
		ResourceDetailDTO expectedResponse = ResourceMapper.entityToResourceDetailDto(expectedResourceEntity);

		// When
		when(resourceRepository.findDetail(resourceId)).thenReturn(Optional.ofNullable(expectedResponse));

		// Then
		ResourceDetailDTO response = exampleService.readResource(resourceId);
		Assert.assertEquals(expectedResponse, response);
	}

	@Order(3)
	@DisplayName("3. 리소스 목록 조회 성공")
	@Test
	public void succeededToRetrieveResources() {
		// Given
		PaginationRequestDTO paginationRequestDTO = DTOStub.getPagination();
		Page<ResourceListDTO> expectedResourceEntity = EntitySub.getPagination(
				paginationRequestDTO.getOffset(),
				paginationRequestDTO.getLimit(),
				DTOStub.getResourceListDTO(EntitySub.getResource())
		);
		PageRequest pageRequest = PageRequest.of(paginationRequestDTO.getOffset(), paginationRequestDTO.getLimit());
		PaginationResponseDTO<List<ResourceListDTO>> expectedResponse = ResourceMapper.pageableToDTO(expectedResourceEntity);

		// When
		when(resourceRepository.findAllResources(pageRequest)).thenReturn(expectedResourceEntity);

		// Then
		PaginationResponseDTO<List<ResourceListDTO>> response = exampleService.readResources(paginationRequestDTO);
		Assert.assertEquals(expectedResponse, response);
	}

	@Order(4)
	@DisplayName("4. 리소스 수정 성공")
	@Test
	public void succeededToUpdateResource() {
		// Given
		int resourceId = EntitySub.getResource().getId();
		ResourceDTO resourceDTO = DTOStub.getResource();
		ResourceEntity expectedResourceEntity = EntitySub.getResource();
		ResourceDetailDTO expectedResponse = ResourceMapper.entityToResourceDetailDto(expectedResourceEntity);

		// When
		when(resourceRepository.findById(resourceId)).thenReturn(Optional.of(expectedResourceEntity));
		when(resourceRepository.save(any(ResourceEntity.class))).thenReturn(expectedResourceEntity);

		// Then
		ResourceDetailDTO response = exampleService.updateResource(resourceId, resourceDTO);
		Assert.assertEquals(expectedResponse, response);
	}

	@Order(5)
	@DisplayName("5. 리소스 삭제 성공")
	@Test
	public void succeededToDeleteResource() {
		// Given
		int resourceId = EntitySub.getResource().getId();
		ResourceEntity expectedResourceEntity = EntitySub.getResource();

		AtomicReference<ResourceEntity> deletedResourceEntity = new AtomicReference<>();

		// When
		when(resourceRepository.findById(resourceId)).thenReturn(Optional.of(expectedResourceEntity));

		// Then
		exampleService.deleteResource(resourceId);
		Assert.assertNull(deletedResourceEntity.get());
	}

	@Order(6)
	@DisplayName("6. 리소스 대상 없음")
	@Test
	public void notFoundResource() {
		// Given
		int resourceId = EntitySub.getResource().getId();

		// When
		when(resourceRepository.findDetail(resourceId)).thenReturn(Optional.ofNullable(null));

		// Then
		assertThrows(NotFoundException.class, () -> {exampleService.readResource(resourceId);});
	}
}
