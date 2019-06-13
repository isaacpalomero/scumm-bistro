package com.scumm.api.validators;

import com.scumm.api.contracts.DishContract;
import com.scumm.core.domain.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DishValidatorTest {

    private CategoryRepository categoryRepository;
    private IContractValidator<DishContract> dishContractValidator;
    private DishContract dishContract;

    @Before
    public void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        dishContractValidator = new DishContractValidator(categoryRepository);
        dishContract = new DishContract();
        dishContract.setCategoryId(new ObjectId().toString());
    }

    @Test
    public void validationSuccess() {
        // Expect
        ObjectId categoryId = new ObjectId(dishContract.getCategoryId());
        when(categoryRepository.existsById(categoryId)).thenReturn(true);

        // Test
        boolean isValid = dishContractValidator.validate(dishContract);

        // Verification
        verify(categoryRepository, times(1)).existsById(categoryId);
        Assert.assertTrue(isValid);
    }

    @Test
    public void validationFailure() {
        // Expect
        ObjectId categoryId = new ObjectId(dishContract.getCategoryId());
        when(categoryRepository.existsById(categoryId)).thenReturn(false);

        // Test
        boolean isValid = dishContractValidator.validate(dishContract);

        // Verification
        verify(categoryRepository, times(1)).existsById(categoryId);
        Assert.assertFalse(isValid);
    }

}
