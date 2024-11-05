package org.example.receiptDemo.service;

public interface InspectService {
    void createInspect(String batch,String name, String telephone);


    void doInspect(String checkid, String name, String telephone, Double totalnum, Long specid);
}
