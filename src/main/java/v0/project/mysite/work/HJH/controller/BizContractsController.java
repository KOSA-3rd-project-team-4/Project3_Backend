package v0.project.mysite.work.HJH.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v0.project.mysite.work.HJH.model.BizContracts;
import v0.project.mysite.work.HJH.service.BizContractsService;
import v0.project.mysite.work.HJH.service.BizContractsService;

import java.util.List;

@RestController
@RequestMapping("/query/bizcontracts")
public class BizContractsController {

    private final BizContractsService bizContractsService;

    public BizContractsController(BizContractsService bizContractsService) {
        this.bizContractsService = bizContractsService;
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<BizContracts> selectById(@PathVariable int id) {
        BizContracts bizContracts = bizContractsService.selectById(id);
        return ResponseEntity.ok(bizContracts);
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<BizContracts>> selectAll() {
        List<BizContracts> bizContracts = bizContractsService.selectAll();
        return ResponseEntity.ok(bizContracts);
    }

    @PostMapping("/insert")
    public ResponseEntity<BizContracts> insert(@RequestBody BizContracts bizContracts) {
        bizContractsService.insert(bizContracts);
        return ResponseEntity.status(201).body(bizContracts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody BizContracts bizContracts) {
        bizContracts.setBiz_contracts_id(id);
        bizContractsService.update(bizContracts);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bizContractsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
