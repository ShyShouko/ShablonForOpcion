package com.example.demo.service;

import com.example.demo.model.Description;
import com.example.demo.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionService {

    private final DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionService(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    public List<Description> getAllDescriptionsSortedByNumber() {
        return descriptionRepository.findAllByOrderByNumberAsc();
    }

    public void saveDescription(Description description) {
        descriptionRepository.save(description);
    }

    public Description getDescriptionById(String id) {
        return descriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Description not found with id: " + id));
    }

    public void updateDescription(String id, Description updatedDescription) {
        Description existingDescription = getDescriptionById(id);
        updateDescriptionFields(existingDescription, updatedDescription);
        descriptionRepository.save(existingDescription);
    }

    public void deleteDescription(String id) {
        Description description = getDescriptionById(id);
        descriptionRepository.deleteById(id);
    }

    public List<Description> getDescriptionsByUserId(String userId) {
        return descriptionRepository.findByUserId(userId);
    }

    private void updateDescriptionFields(Description existingDescription, Description updatedDescription) {
        existingDescription.setNumber(updatedDescription.getNumber());
        existingDescription.setManager(updatedDescription.getManager());
        existingDescription.setRerun(updatedDescription.getRerun());
        existingDescription.setInvoiceagreement(updatedDescription.getInvoiceagreement());
        existingDescription.setCustomer(updatedDescription.getCustomer());
        existingDescription.setProtection(updatedDescription.getProtection());
        existingDescription.setEmbossing(updatedDescription.getEmbossing());
        existingDescription.setBookOp(updatedDescription.getBookOp());
        existingDescription.setBox(updatedDescription.getBox());
        existingDescription.setNeedHelp(updatedDescription.getNeedHelp());
        existingDescription.setAddCond(updatedDescription.getAddCond());
        existingDescription.setDateReception(updatedDescription.getDateReception());
        existingDescription.setDateOfLayout(updatedDescription.getDateOfLayout());
        existingDescription.setDateRun(updatedDescription.getDateRun());

        // Обновить связанные продукты
        existingDescription.getProducts().clear();
        existingDescription.getProducts().addAll(updatedDescription.getProducts());
    }
}
