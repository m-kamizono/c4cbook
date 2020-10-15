package jp.co.c4c.controller.ctrl;

import jp.co.c4c.db.dto.ApiResponse;
import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.co.c4c.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoApiController {
    @Autowired
    TopService topService;

    @RequestMapping(value = "/api/demo", method = RequestMethod.GET)
    public ResponseEntity<Object> showBookList() {
        ApiResponse<V_TopAndDetailDto> response = new ApiResponse<>();

        List<V_TopAndDetailDto> v_topAndDetailDtoList = topService.getAllBooks();

        response.setStatus("Success");
        response.setDataList(v_topAndDetailDtoList);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


}
