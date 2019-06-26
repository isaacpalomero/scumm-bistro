package com.scumm.micros.dish.validators.handlers;

import com.clitellum.annotations.MessageHandler;

import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Category.Reply", contractType = CategoryReplyContract.class)
public class DishValidatorReplySuccessHandler {

}
