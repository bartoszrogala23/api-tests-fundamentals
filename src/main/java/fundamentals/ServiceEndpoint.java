package fundamentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {

    LOCAL_HOST("http://localhost:8080"),
    LOCAL_HOST_OK(LOCAL_HOST.endpoint + "/ok"),
    QUERY_PARAMS(LOCAL_HOST.endpoint + "/query_params"),
    GET_PEOPLE(LOCAL_HOST.endpoint + "/get_all_people"),
    GET_PEOPLE_SLICED(LOCAL_HOST.endpoint + "/get_all_people_sliced"),
    GET_PEOPLE_PAGED(LOCAL_HOST.endpoint + "/get_all_people_paged"),
    GET_PEOPLE_BY_ID(LOCAL_HOST.endpoint + "/get_all_people_by"),
    HUMAN(LOCAL_HOST.endpoint + "/human"),
    HUMAN_BY_ID(HUMAN.endpoint + "/{human_id}");

    private final String endpoint;
}

//model parser
//package com.puma.plm.api.core.labellingpackagingservice;
//
//import java.util.List;
//
//import com.puma.plm.api.core.labellingpackagingservice.models.FormDataSupplier;
//import com.puma.plm.api.core.labellingpackagingservice.models.OverviewSearch;
//import com.puma.plm.api.core.labellingpackagingservice.models.Variation;
//import com.puma.plm.api.core.parser.ResponseParser;
//import lombok.NoArgsConstructor;
//
//import static com.puma.plm.api.core.labellingpackagingservice.LabellingPackagingService.getVariationWithId;
//import static com.puma.plm.api.core.labellingpackagingservice.util.LabellingPackagingUtil.getFirstVariationIdFound;
//import static com.puma.plm.api.core.parser.ObjectParser.toJson;
//import static lombok.AccessLevel.NONE;
//import static org.apache.http.HttpStatus.SC_OK;
//
//@NoArgsConstructor(access = NONE)
//public class LabellingPackagingModelParser {
//
//    public static List<FormDataSupplier> createFormDataSuppliersRequest() {
//        var response = LabellingPackagingService.getFormDataSuppliers(SC_OK);
//
//        return ResponseParser.parseCollection(response, FormDataSupplier[].class);
//    }
//
//    public static OverviewSearch createOverviewSearchRequest(Variation body) {
//        var response = LabellingPackagingService.postSearchOverview(toJson(body), SC_OK);
//
//        return ResponseParser.parse(response, OverviewSearch.class);
//    }
//
//    public static Variation getVariation() {
//        var response = getVariationWithId(getFirstVariationIdFound(), SC_OK);
//
//        return ResponseParser.parse(response, Variation.class);
//    }
//}