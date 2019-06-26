package com.scumm.micros.category.sync.handlers;

import com.clitellum.annotations.MessageHandler;
import com.clitellum.services.handlers.BaseHandler;
import com.clitellum.services.handlers.HandlerMessageException;
import com.scumm.core.domain.exceptions.ModelNotFoundException;
import com.scumm.micros.category.sync.domain.entities.Category;
import com.scumm.micros.category.sync.domain.servicies.ICategorySyncService;
import com.scumm.micros.contracts.categories.CategoryReplyContract;
import com.scumm.micros.contracts.categories.CategoryReplyErrorContract;
import com.scumm.micros.contracts.categories.CategoryRequestContract;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MessageHandler(key = "Category.Request", contractType = CategoryRequestContract.class)
public class CategorySyncHandler extends BaseHandler<CategoryRequestContract> {

    private ICategorySyncService service;
    private ModelMapper mapper;

    private final String categoryReplyRoutingKey = "Category.Reply";
    private final String categoryReplyErrorRoutingKey = "Category.ReplyError";

    @Autowired
    public CategorySyncHandler(ICategorySyncService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void handle() throws HandlerMessageException {
        CategoryReplyErrorContract errorContract;
        try {
            Category category = service.getCategory(getContract());
            CategoryReplyContract categoryReplyContract = mapper.map(category, CategoryReplyContract.class);
            send(categoryReplyRoutingKey, categoryReplyContract);
            return;
        } catch (ModelNotFoundException e) {
            errorContract = new CategoryReplyErrorContract();
            errorContract.setMessage(e.getMessage());
            errorContract.setCode(400);

        } catch (Exception e) {
            errorContract = new CategoryReplyErrorContract();
            errorContract.setMessage(e.getMessage());
            errorContract.setCode(500);
        }
        send(categoryReplyErrorRoutingKey, errorContract);
    }
}
