package jp.co.c4c.controller.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.c4c.controller.form.DetailForm;
import jp.co.c4c.db.dto.ApiResponse;
import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.co.c4c.service.DetailService;


/**
 * @author takayukiyamaoka
 *
 */
@RestController
public class DetailApiController {

    @Autowired
    DetailService detailService;

    /**
     * 予約・貸出手続き
     * @param bk_T_LendDto
     * @return
     */
    @RequestMapping(value = "/api/proceedLendReserve", method = RequestMethod.POST)
    public ResponseEntity<Object> lendReserveBook(@RequestBody BK_T_LendDto bk_T_LendDto) {
        System.out.println(bk_T_LendDto.toString()); //確認用

        ApiResponse<BK_T_LendDto> response = new ApiResponse<>("sucess", bk_T_LendDto);
        detailService.saveLendBook(bk_T_LendDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /**
     * 貸出履歴をBookIdで取得
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/api/getLendHistory", method = RequestMethod.GET)
    public ResponseEntity<Object> getLendHistory(@RequestParam("bookId") int bookId) {
        DetailForm detailForm = new DetailForm();
        detailForm.setV_LendHistoryDtoList(detailService.getLendHistorysByBookId(bookId));

        ApiResponse<List<V_LendHistoryDto>> response = new ApiResponse<>("sucess",
                detailForm.getV_LendHistoryDtoList());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /**
     * 予約・貸出履歴更新
     * @param bk_T_LendDto
     * @return
     */
    @RequestMapping(value = "/api/updateLendHistory", method = RequestMethod.POST)
    public ResponseEntity<Object> postUpdateLendHistory(@RequestBody BK_T_LendDto bk_T_LendDto) {

        int bookId = bk_T_LendDto.getBookId();
        DetailForm detailForm = new DetailForm();
        detailForm.setV_LendHistoryDtoList(detailService.getLendHistorysByBookId(bookId));

        ApiResponse<BK_T_LendDto> response = new ApiResponse<>();

        System.out.println(bk_T_LendDto.getLendStatus());

        if (bk_T_LendDto.getLendStatus() == 11) {
            detailService.updateLendBook(bk_T_LendDto);
            response.setStatus("貸出手続きが完了しました。");
            response.setData(bk_T_LendDto);
        } else if (bk_T_LendDto.getLendStatus() == 19) {
            detailService.updateLendBook(bk_T_LendDto);
            response.setStatus("返却手続きが完了しました。");
            response.setData(bk_T_LendDto);
        } else if (bk_T_LendDto.getLendStatus() == 10) {
            detailService.updateLendBook(bk_T_LendDto);
            response.setStatus("更新しました。");
            response.setData(bk_T_LendDto);
        }

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /**
     * 予約取消
     * @param lendId
     * @return
     */
    @RequestMapping(value = "/api/cancelReserve", method = RequestMethod.POST)
    public ResponseEntity<Object> postDeleteLendHistory(@RequestBody int lendId) {
        ApiResponse<BK_T_LendDto> response = new ApiResponse<>();

        detailService.deleteLendBook(lendId);
        response.setStatus("予約を取り消しました。");

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /**
     * おすすめ
     * @param bk_T_RecomDto
     * @return
     */
    @RequestMapping(value = "/api/sendRecomendation", method = RequestMethod.POST)
    public ResponseEntity<Object> sendRecommendation(@RequestBody BK_T_RecomDto bk_T_RecomDto) {
        // おすすめする人をDBから取得
        BK_M_MemBasicDto bk_M_MemBasicDto = detailService.getMemberById(bk_T_RecomDto.getToMemId());
        String toMemName = bk_M_MemBasicDto.getMemName();
        ApiResponse<BK_T_RecomDto> response = new ApiResponse<>();
        response.setStatus(toMemName + "さんにおすすめしました。");
        //　おすすめを登録
        detailService.saveRecom(bk_T_RecomDto);

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /**
     * レビュー送信
     * @param bk_T_LendDto
     * @return
     */
    @RequestMapping(value = "/api/sendReview", method = RequestMethod.POST)
    public ResponseEntity<Object> sendReview(@RequestBody BK_T_LendDto bk_T_LendDto) {
        ApiResponse<BK_T_LendDto> response = new ApiResponse<>();

        detailService.saveReview(bk_T_LendDto);

        response.setStatus("レビューを登録しました。");
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }



}
