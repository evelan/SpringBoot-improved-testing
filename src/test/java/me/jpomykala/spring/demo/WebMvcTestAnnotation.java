package me.jpomykala.spring.demo;

import me.jpomykala.spring.demo.controller.HomeController;
import me.jpomykala.spring.demo.service.MoonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Evelan on 23/10/2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class WebMvcTestAnnotation {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoonService moonService;

    @Before
    public void setUp() throws Exception {
        given(moonService.getTemperature()).willReturn(53f);
    }

    @Test
    public void whenShowMoonTemperature_correct() throws Exception {
        mockMvc.perform(get("/moon-temperature")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("53"));
    }
}
