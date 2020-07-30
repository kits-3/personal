package repository;

import java.util.List;

import entity.ReceiptEntity;

public interface ReceiptRepository {
 void add(ReceiptEntity repEntity);
 void update(ReceiptEntity repEntity);
 void delete(int id);
 List<ReceiptEntity> printReceipt();
 List<ReceiptEntity> findById(int id);
 List<ReceiptEntity> findByPhone(String numberphone);
}
