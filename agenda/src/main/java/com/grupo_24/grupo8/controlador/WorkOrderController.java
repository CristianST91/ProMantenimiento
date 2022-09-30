package com.grupo_24.grupo8.controlador;

import com.grupo_24.grupo8.modelo.WorkOrder;
import com.grupo_24.grupo8.servicios.WorkOrderService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workorder")
public class WorkOrderController {
    private WorkOrderService service;

    public WorkOrderController(){
        this.service = new WorkOrderService();
    }
    
    @PostMapping
    @CrossOrigin("*")
    public String createworkOrder(@RequestBody WorkOrder workOrder){
        String message = "";
        try {
            service.createWorkOrder(workOrder);
            message = "work order created successfully";
        } catch (Exception e) {
            message = e.getMessage();
            message += "\nMaybe the Work order Number is already in use";
        }
        return message;
    }

    @PutMapping
    @CrossOrigin("*")
    public String updateworkOrder(@RequestBody WorkOrder workOrder){
        String message = "";
        try {
            service.updateWorkOrder(workOrder);
            message = "Updated successfully";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<WorkOrder> getWorkOrdersList(){
        List<WorkOrder> workOrder = new ArrayList<>();
        try {
            workOrder = service.getWorkOrdersList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workOrder;
    }

    @GetMapping("/number")
    @CrossOrigin("*")
    public List<WorkOrder> getWorkOrderbyNumber(@RequestParam int order){
        List<WorkOrder> workOrder = new ArrayList<>();
        try {
            workOrder = service.getWorkOrderbyNumber(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workOrder;
    }

    @GetMapping("/order/{user}")
    @CrossOrigin("*")
    public List<WorkOrder> getWorkOrderbyId(@PathVariable(name="user") String userName){
        List<WorkOrder> workOrder = new ArrayList<>();
        try {
            workOrder = service.getWorkOrderbyUserName(userName);
       } catch (Exception e) {
            e.printStackTrace();
       }
       return workOrder;
    }

    @DeleteMapping("/{order}")
    @CrossOrigin("*")
    public String deleteworkOrderbyId(@PathVariable(name="order") int order){
        String message = "";
        try {
            service.deleteWorkOrderbyId(order);
            message = "Deleted successfully";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

}
