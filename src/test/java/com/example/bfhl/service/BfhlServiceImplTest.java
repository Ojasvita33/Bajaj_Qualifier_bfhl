package com.example.bfhl.service;

import com.example.bfhl.dto.BfhlRequest;
import com.example.bfhl.dto.BfhlResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BfhlServiceImplTest {

    private final BfhlServiceImpl service = new BfhlServiceImpl();

    @Test
    void processesExampleA() {
        BfhlRequest request = new BfhlRequest();
        request.setData(List.of("a", "1", "334", "4", "R", "$"));

        BfhlResponse response = service.processData(request);

        assertTrue(response.isIs_success());
        assertEquals("ojasvita_27082005", response.getUser_id());
        assertEquals("ojrn777@gmail.com", response.getEmail());
        assertEquals("2310990756", response.getRoll_number());
        assertEquals(List.of("1"), response.getOdd_numbers());
        assertEquals(List.of("334", "4"), response.getEven_numbers());
        assertEquals(List.of("A", "R"), response.getAlphabets());
        assertEquals(List.of("$"), response.getSpecial_characters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcat_string());
    }

    @Test
    void processesExampleB() {
        BfhlRequest request = new BfhlRequest();
        request.setData(List.of("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));

        BfhlResponse response = service.processData(request);

        assertEquals(List.of("5"), response.getOdd_numbers());
        assertEquals(List.of("2", "4", "92"), response.getEven_numbers());
        assertEquals(List.of("A", "Y", "B"), response.getAlphabets());
        assertEquals(List.of("&", "-", "*"), response.getSpecial_characters());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcat_string());
    }

    @Test
    void processesExampleC() {
        BfhlRequest request = new BfhlRequest();
        request.setData(List.of("A", "ABCD", "DOE"));

        BfhlResponse response = service.processData(request);

        assertEquals(List.of(), response.getOdd_numbers());
        assertEquals(List.of(), response.getEven_numbers());
        assertEquals(List.of("A", "ABCD", "DOE"), response.getAlphabets());
        assertEquals(List.of(), response.getSpecial_characters());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcat_string());
    }

    @Test
    void handlesNullDataAsEmptyInput() {
        BfhlRequest request = new BfhlRequest();

        BfhlResponse response = service.processData(request);

        assertTrue(response.isIs_success());
        assertEquals(List.of(), response.getOdd_numbers());
        assertEquals(List.of(), response.getEven_numbers());
        assertEquals(List.of(), response.getAlphabets());
        assertEquals(List.of(), response.getSpecial_characters());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcat_string());
    }
}
