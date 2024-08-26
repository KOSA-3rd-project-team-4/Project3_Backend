package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.BaseElectronicContracts;
import v0.project.mysite.work.HJH.service.BaseElectronicContractsService;

import java.util.List;

@RestController
@RequestMapping("/query/baseelectroniccontracts")
public class BaseElectronicContractsController {

    private final BaseElectronicContractsService bizElectronicContractsService;

    public BaseElectronicContractsController(BaseElectronicContractsService bizElectronicContractsService) {
        this.bizElectronicContractsService = bizElectronicContractsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<BaseElectronicContracts> selectById(@PathVariable int id) {
        BaseElectronicContracts image = bizElectronicContractsService.selectById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<BaseElectronicContracts>> selectAll() {
        List<BaseElectronicContracts> images = bizElectronicContractsService.selectAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping("/insert")
    public ResponseEntity<BaseElectronicContracts> insert(@RequestBody BaseElectronicContracts image) {
        bizElectronicContractsService.insert(image);
        return ResponseEntity.status(201).body(image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody BaseElectronicContracts image) {
        image.setContracts_id(id);
        bizElectronicContractsService.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bizElectronicContractsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
