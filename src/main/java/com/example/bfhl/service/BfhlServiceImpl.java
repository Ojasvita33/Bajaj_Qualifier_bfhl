package com.example.bfhl.service;

import com.example.bfhl.dto.BfhlRequest;
import com.example.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        List<String> data = request.getData();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        int sum = 0;
        StringBuilder allLetters = new StringBuilder();

        if (data != null) {
            for (String item : data) {
                if (item.matches("-?\\d+")) {
                    int number = Integer.parseInt(item);
                    sum += number;

                    if (number % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (item.matches("[a-zA-Z]+")) {
                    alphabets.add(item.toUpperCase());
                    allLetters.append(item);
                } else {
                    specialCharacters.add(item);
                }
            }
        }

        BfhlResponse response = new BfhlResponse();
        response.setIs_success(true);
        response.setUser_id("ojasvita_27082005");
        response.setEmail("ojrn777@gmail.com");
        response.setRoll_number("2310990756");
        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);
        response.setSum(String.valueOf(sum));
        response.setConcat_string(buildConcatString(allLetters.toString()));

        return response;
    }

    private String buildConcatString(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}