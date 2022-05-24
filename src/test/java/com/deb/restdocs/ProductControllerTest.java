package com.deb.restdocs;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.deb.restdocs.controller.ProductController;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnProductCode() throws Exception{
       MvcResult res = this.mockMvc.perform(MockMvcRequestBuilders
        		.get("/products/SMG-TV"))
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		//.andExpect(MockMvcResultMatchers.content().string("Samsung TV"))
        		.andDo(MockMvcRestDocumentation.document("product/get-product-by-id"))
        		.andReturn();
       res.getResponse().getContentAsString().contains("Samsung TV");
        
    }
}
