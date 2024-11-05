package org.example.receiptDemo.service;

import org.example.receiptDemo.model.ReceiptModel.ReceiptRequest;

public interface ReceiptService {
    void createReceipt(ReceiptRequest request);
}
