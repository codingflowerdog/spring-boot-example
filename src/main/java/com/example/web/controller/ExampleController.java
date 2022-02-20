package com.example.web.controller;

import com.example.web.annotation.ActionMapping;
import com.example.web.data.dto.request.PaginationRequestDTO;
import com.example.web.data.dto.request.ResourceDTO;
import com.example.web.data.dto.response.PaginationResponseDTO;
import com.example.web.data.dto.response.resource.ResourceDetailDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.enums.Action;
import com.example.web.service.ExampleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 예제 컨트롤러
 */
@RequestMapping("/api")
@RestController
public class ExampleController {
    // 예제 서비스 DI
    @Autowired
    ExampleService exampleService;

    /**
     * 리소스 생성
     * @param resourceDTO 리소스 정보
     */
    @ActionMapping(Action.CREATE)
    @PostMapping("/resources/resource")
    @ApiOperation(value = "리소스 생성", notes = "리소스를 생성합니다.")
    public ResourceDetailDTO createExample(
            @ApiParam(name = "리소스 정보")
            @RequestBody ResourceDTO resourceDTO
    ) {
        // 리소스 생성
        ResourceDetailDTO response = exampleService.createResource(resourceDTO);

        return response;
    }

    /**
     * 리소스 조회
     * @param resourceId 리소스 번호
     */
    @ActionMapping(Action.RETRIEVE)
    @GetMapping("/resources/{resourceId}")
    @ApiOperation(value = "리소스 조회", notes = "리소스를 조회합니다.")
    public ResourceDetailDTO readExample(
            @ApiParam(name = "리소스 번호", example = "1")
            @PathVariable(name = "resourceId") int resourceId
    ) {
        // 리소스 조회
        ResourceDetailDTO response = exampleService.readResource(resourceId);

        return response;
    }

    /**
     * 리소스 목록 조회
     * @param paginationRequestDTO 페이지네이션 요청 정보
     */
    @ActionMapping(Action.RETRIEVE)
    @GetMapping("/resources")
    @ApiOperation(value = "리소스 조회", notes = "리소스를 조회합니다.")
    public PaginationResponseDTO<List<ResourceListDTO>> readExample(
            PaginationRequestDTO paginationRequestDTO
    ) {
        // 리소스 목록 조회
        PaginationResponseDTO<List<ResourceListDTO>> response = exampleService.readResources(paginationRequestDTO);

        return response;
    }

    /**
     * 리소스 수정
     * @param resourceId 리소스 ID
     * @param resourceDTO 리소스 정보
     */
    @ActionMapping(Action.MODIFY)
    @PutMapping("/resources/{resourceId}")
    @ApiOperation(value = "리소스 수정", notes = "리소스를 수정합니다.")
    public ResourceDetailDTO updateExample(
            @ApiParam(name = "리소스 번호", example = "1")
            @PathVariable(name = "resourceId") int resourceId,
            @ApiParam(name = "리소스 정보")
            @RequestBody ResourceDTO resourceDTO
    ) {
        // 리소스 생성
        ResourceDetailDTO response = exampleService.updateResource(resourceId, resourceDTO);

        return response;
    }

    /**
     * 리소스 삭제
     * @param resourceId 리소스 ID
     */
    @ActionMapping(Action.DELETE)
    @DeleteMapping("/resources/{resourceId}")
    @ApiOperation(value = "리소스 삭제", notes = "리소스를 삭제합니다.")
    public void deleteExample(
            @ApiParam(name = "리소스 번호", example = "1")
            @PathVariable(name = "resourceId") int resourceId
    ) {
        // 리소스 생성
        exampleService.deleteResource(resourceId);
    }
}
