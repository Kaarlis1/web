package lv.va.sludinajumuportals.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AvailabilityController {
    public String status = "503 Service Unavailable";
    public String htmlPost = "<form method=\"post\" action=\"\" class=\"inline\">" +
            "  <button type=\"submit\"  class=\"link-button\">\n" +
            "    method=post\n" +
            "  </button>\n" +
            "</form>";
    public String htmlGet = "<form method=\"get\" action=\"\" class=\"inline\">" +
            "  <button type=\"submit\"  class=\"link-button\">\n" +
            "    method=get\n" +
            "  </button>\n" +
            "</form>";

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String getStatus(@PathVariable String id) {
        return status+"</br>  PathVariable="+id+htmlPost+htmlGet;

    }


    @PostMapping(value = "/{id}")
    @ResponseBody
    public String setStatus(@PathVariable String id) {
        switch (status) {
            case "503 Service Unavailable":
                status = "200 OK";
                break;
            case "200 OK":
                status = "503 Service Unavailable";
                break;
            default:
                status = "default";
                break;
        }

        return status+"</br>  PathVariable="+id+htmlPost+htmlGet;
    }
} 