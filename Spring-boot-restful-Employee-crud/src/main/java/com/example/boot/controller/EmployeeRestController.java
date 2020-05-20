package com.example.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.model.EmployeeBO;
import com.example.boot.model.EmployeeCommand;
import com.example.boot.service.IEmployeeService;

import io.swagger.models.Response;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeCommand cmd) {
		ResponseEntity<?> responseEntity = null;
		try {
			EmployeeBO bo = new EmployeeBO();
			BeanUtils.copyProperties(cmd, bo);
			service.saveEmployee(bo);
			responseEntity = new ResponseEntity<String>("Employee saved with id:" + bo.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("employee not saved", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping("/findall")
	public ResponseEntity<?> findAll() {
		ResponseEntity<?> responseEntity = null;

		try {

			List<EmployeeBO> list = service.findAll();
			List<EmployeeCommand> cmdlist = new ArrayList();
			for (EmployeeBO bo : list) {

				EmployeeCommand cmd = new EmployeeCommand();

				BeanUtils.copyProperties(bo, cmd);
				cmdlist.add(cmd);

			}
			if (list.isEmpty() || list == null)
				responseEntity = new ResponseEntity<String>("employee not found", HttpStatus.BAD_REQUEST);
			else
				responseEntity = new ResponseEntity<List<EmployeeCommand>>(cmdlist, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("employee not found", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id, EmployeeCommand cmd) {

		ResponseEntity<?> responseEntity = null;
		try {
			EmployeeBO bo = service.findById(id);
			BeanUtils.copyProperties(bo, cmd);
			if (cmd == null || cmd.equals("")) {

				responseEntity = new ResponseEntity<String>("no data found", HttpStatus.NO_CONTENT);
			} else {
				responseEntity = new ResponseEntity<EmployeeCommand>(cmd, HttpStatus.OK);

			}
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("invalid request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletById(@PathVariable("id") Integer id) {

		ResponseEntity<?> responseEntity = null;
		try {

			if (id == null) {
				responseEntity = new ResponseEntity<String>("given id is not existed:" + id + " ",
						HttpStatus.NOT_ACCEPTABLE);
			} else {
				service.delteById(id);
				responseEntity = new ResponseEntity<String>("student deleted with id:" + id + " ", HttpStatus.OK);
			}
			service.delteById(id);

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("exception arises:" + id + " ",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;

	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeCommand> updateById(@RequestBody EmployeeCommand cmd) {

		ResponseEntity<EmployeeCommand> responseEntity = null;
		EmployeeBO bo = null;
		try {
			bo = service.findById(cmd.getId());

			BeanUtils.copyProperties(cmd, bo);
			service.saveEmployee(bo);
			responseEntity = new ResponseEntity<EmployeeCommand>(cmd, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}

	@GetMapping("/find/{name}")
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {

		ResponseEntity<?> responseEntity = null;
		try {
			if (name.isEmpty()) {

				responseEntity = new ResponseEntity<String>("employee not found with given name:" + name,
						HttpStatus.NO_CONTENT);

			} else {
				EmployeeBO ename = service.findByName(name);
				responseEntity = new ResponseEntity<EmployeeBO>(ename, HttpStatus.OK);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
}
