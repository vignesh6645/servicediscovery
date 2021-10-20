package com.example.workerDetails.service;

import com.example.workerDetails.baseResponse.BaseResponse;
import com.example.workerDetails.dto.WorkerDTO;
import com.example.workerDetails.model.Department;
import com.example.workerDetails.model.worker;
import com.example.workerDetails.repository.DepartmentRepository;
import com.example.workerDetails.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service

public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

   /* @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;*/

  /*  public Optional<URI> servieceUrl(String service){
        return discoveryClient.getInstances(service).stream()
                .findFirst().map(serviceInstance -> serviceInstance.getUri());
    }*/

    public BaseResponse add(WorkerDTO workerDTO) {

        worker workers = new worker();
        BaseResponse baseResponse = new BaseResponse();
        workers.setName(workerDTO.getName());
        workers.setAge(workerDTO.getAge());
        workerRepository.save(workers);

        workerDTO.getDepartmentDTO().stream().forEachOrdered(departmentDTO -> {

            Department department = new Department();
            department.setDept_name(departmentDTO.getDept_name());
            department.setDept_members(departmentDTO.getDept_members());
            department.setWorker(workers);
            departmentRepository.save(department);
        });

        baseResponse.setData(workerDTO);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");

        return baseResponse;
    }

    public List<Department> listAll() {

        return departmentRepository.findAll();
    }

    public Department getWorkerById(Integer id){
        return departmentRepository.findById(id).orElse(null);
    }

    public BaseResponse deleted() {
        BaseResponse baseResponse = new BaseResponse();
        workerRepository.deleteAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("employee info deleted successfully..");
        return baseResponse;
    }
    public BaseResponse updatedetail(WorkerDTO workerDTO) {

        worker existworkers = workerRepository.findById(workerDTO.getId()).orElse(null);
        BaseResponse baseResponse=new BaseResponse();
        existworkers.setName(workerDTO.getName());
        existworkers.setAge(workerDTO.getAge());
        workerRepository.save(existworkers);

        workerDTO.getDepartmentDTO().stream().forEachOrdered(departmentDTO -> {

            Department existdepartment = departmentRepository.findById(departmentDTO.getDept_Id()).orElse(null);
            existdepartment.setDept_name(departmentDTO.getDept_name());
            existdepartment.setDept_members(departmentDTO.getDept_members());
            existdepartment.setWorker(existworkers);
            departmentRepository.save(existdepartment);
        });
        baseResponse.setData(workerDTO);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        return baseResponse;
    }
}
