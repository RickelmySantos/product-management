package com.management.product.service;

import com.management.product.entity.Supplier;
import com.management.product.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupplierService {

 private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public Supplier searchForId(Long id){
        return supplierRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Fornecedor não cadastrado"));
    }

    public Supplier saveAll(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updateSupplier){
        Supplier existingSupplier = searchForId(id);
        existingSupplier.setName(updateSupplier.getName());
        existingSupplier.setAddress(updateSupplier.getAddress());
        existingSupplier.setContact(updateSupplier.getContact());
        return supplierRepository.save(existingSupplier);
    }

    public void deleteSupplier(Long id){
        Supplier supplier = searchForId(id);
        supplierRepository.delete(supplier);
    }
}
