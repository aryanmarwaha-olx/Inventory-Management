//package in.olx.inventorymanagement.service;
//
//import in.olx.inventorymanagement.model.dto.InventoryDTO;
//import in.olx.inventorymanagement.model.entity.InventoryEntity;
//import in.olx.inventorymanagement.model.enums.PrimaryStatus;
//import in.olx.inventorymanagement.model.enums.ProductType;
//import in.olx.inventorymanagement.repository.InventoryRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.data.domain.*;
//
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class InventoryServiceImplTest {
//
//    @Test
//    void testGetAllInventoriesWithPagination() {
//        // Mock repository
//        InventoryRepository inventoryRepository = Mockito.mock(InventoryRepository.class);
//
//        // Create sample entity
//        InventoryEntity entity = new InventoryEntity();
//        entity.setSkuId("SKU123");
//        entity.setPrimaryStatus(PrimaryStatus.SOLD);
//        entity.setProductType(ProductType.CAR);
//        entity.setCostToCompany(200000);
//        entity.setStoreLocation("Delhi");
//        entity.setDealer("CarZone");
//        entity.setMiddleMan("Aman");
//
//        // Mock page return
//        Page<InventoryEntity> mockPage = new PageImpl<>(Collections.singletonList(entity));
//        Mockito.when(inventoryRepository.findAll(PageRequest.of(0, 10))).thenReturn(mockPage);
//
//        // Create service
//        InventoryServiceImpl service = new InventoryServiceImpl(inventoryRepository);
//
//        // Call method
//        Page<InventoryDTO> result = service.getAllInventoriesWithPagination(0);
//
//        // Assert values
//        InventoryDTO dto = result.getContent().get(0);
//        assertEquals("SKU123", dto.getSku());
//        assertEquals("Delhi", dto.getPrimaryLocation());
//    }
//}
