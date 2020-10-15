package jp.co.c4c.controller.ctrl;

import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.co.c4c.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Parameter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller

public class DemoStreamController {
    @Autowired
    TopService topService;

    @RequestMapping("/demo2")
    public String init(TopForm form, @RequestParam(name = "param", required = false) String param) {

        List<V_TopAndDetailDto> v_topAndDetailDtoList = topService.getAllBooks();
        if (param == null) {
            form.setTopAndDetailDtoList(v_topAndDetailDtoList);
            return "demo2";
        }

        List<V_TopAndDetailDto> sortedList;
        switch (param) {
            case "1":
                // あいうえお順
                sortedList = v_topAndDetailDtoList.stream()
                        .sorted(Comparator.comparing(V_TopAndDetailDto::getTitleKana))
                        .collect(Collectors.toList());
                break;
            case "2":
                // お気に入り数順
                sortedList = v_topAndDetailDtoList.stream()
                        .sorted(Comparator.comparing(V_TopAndDetailDto::getFavCount).reversed())
                        .collect(Collectors.toList());
                break;
            case "3":
                // 読まれた回数順
                sortedList = v_topAndDetailDtoList.stream()
                        .sorted(Comparator.comparing(V_TopAndDetailDto::getLendCount).reversed())
                        .collect(Collectors.toList());
                break;
            default:
                sortedList = v_topAndDetailDtoList;
                break;
        }

        form.setTopAndDetailDtoList(sortedList);
        return "demo2";

    }

}
