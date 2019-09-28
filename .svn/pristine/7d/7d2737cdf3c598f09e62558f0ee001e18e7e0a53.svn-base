package com.mingyuansoftware.aifactory.controller;


import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.StaffPermission;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UIController {

    /**
     * 登录页面
     * @param model
     * @return
     */
    @RequestMapping("/index/login")
    public String login(Model model){
        return "index/login";
    }

    /**
     * 主体页面
     * @param model
     * @return
     */


    /**
     * 控制台
     * @param model
     * @return
     */
    @RequestMapping("/index/index")
    public String index(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "index/index";
    }

    /**
     * 主页
     * @param model
     * @return
     */
    @RequestMapping("/index/homepage")
    public String homepage(Model model){
        return "index/homepage";
    }

    /**
     * 修改登入人员信息
     * @param model
     * @return
     */
    @RequestMapping("/index/password")
    public String password(Model model){
        return "index/password";
    }


    /**
     * 销售订单-列表
     * @param model
     * @return
     */
    @RequestMapping("/salesOrders/index")
    public String salesOrdersIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "salesOrders/index";
    }

    /**
     * 销售订单-新增
     * @param model
     * @return
     */
    @RequestMapping("/salesOrders/add")
    public String salesOrdersAdd(Model model){
        return "salesOrders/add";
    }

    /**
     * 销售订单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/salesOrders/edit")
    public String salesOrdersEdit(Model model,String salesOrderId){
        model.addAttribute("salesOrderId",salesOrderId);
        return "salesOrders/edit";
    }

    /**
     * 销售订单-查看
     * @param model
     * @return
     */
    @RequestMapping("/salesOrders/open")
    public String salesOrdersOpen(Model model,String salesOrderId){
        model.addAttribute("salesOrderId",salesOrderId);
        return "salesOrders/open";
    }

    /**
     * 销售订单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/salesOrders/showTable")
    public String salesOrdersShowTable(Model model,String dataIndex,String orderType){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("orderType",orderType);
        return "salesOrders/showTable";
    }




    /**
     * 销售退货单-列表
     * @param model
     * @return
     */
    @RequestMapping("/salesReturn/index")
    public String salesReturnIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "salesReturn/index";
    }

    /**
     * 销售退货单-新增
     * @param model
     * @return
     */
    @RequestMapping("/salesReturn/add")
    public String salesReturnAdd(Model model){
        return "salesReturn/add";
    }

    /**
     * 销售退货单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/salesReturn/edit")
    public String salesReturnEdit(Model model, String salesReturnId){
        model.addAttribute("salesReturnId",salesReturnId);
        return "salesReturn/edit";
    }

    /**
     * 销售退货单-查看
     * @param model
     * @return
     */
    @RequestMapping("/salesReturn/open")
    public String salesReturnOpen(Model model, String salesReturnId){
        model.addAttribute("salesReturnId",salesReturnId);
        return "salesReturn/open";
    }

    /**
     * 销售退货单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/salesReturn/showTable")
    public String salesReturnShowTable(Model model, String dataIndex, String salesOrderId){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("salesOrderId",salesOrderId);
        return "salesReturn/showTable";
    }




    /**
     * 销售明细-列表
     * @param model
     * @return
     */
    @RequestMapping("/salesDetails/index")
    public String salesDetailsIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "salesDetails/index";
    }




    /**
     * 货单管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/manifestManagement/index")
    public String manifestManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "manifestManagement/index";
    }

    /**
     * 货单管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/manifestManagement/open")
    public String manifestManagementOpen(Model model, String shipmentId){
        model.addAttribute("shipmentId",shipmentId);
        return "manifestManagement/open";
    }



    /**
     * 采购申请单-列表
     * @param model
     * @return
     */
    @RequestMapping("/purchaseRequisition/index")
    public String purchaseRequisitionIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "purchaseRequisition/index";
    }

    /**
     * 采购申请单-新增
     * @param model
     * @return
     */
    @RequestMapping("/purchaseRequisition/add")
    public String purchaseRequisitionAdd(Model model){
        return "purchaseRequisition/add";
    }

    /**
     * 采购申请单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/purchaseRequisition/edit")
    public String purchaseRequisitionEdit(Model model,String purchaseApplyDetailsId){
        model.addAttribute("purchaseApplyDetailsId",purchaseApplyDetailsId);
        return "purchaseRequisition/edit";
    }

    /**
     * 采购申请单-查看
     * @param model
     * @return
     */
    @RequestMapping("/purchaseRequisition/open")
    public String purchaseRequisitionOpen(Model model){
        return "purchaseRequisition/open";
    }

    /**
     * 采购申请单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/purchaseRequisition/showTable")
    public String purchaseRequisitionShowTable(Model model,String dataIndex){
        model.addAttribute("dataIndex",dataIndex);
        return "purchaseRequisition/showTable";
    }

    /**
     * 采购申请单-生产采购订单
     * @param model
     * @return
     */
    @RequestMapping("/purchaseRequisition/generatingOrders")
    public String purchaseRequisitionGeneratingOrders(Model model,String detailsId){
        model.addAttribute("detailsId",detailsId);
        return "purchaseRequisition/generatingOrders";
    }




    /**
     * 采购订单-列表
     * @param model
     * @return
     */
    @RequestMapping("/purchaseOrder/index")
    public String purchaseOrderIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "purchaseOrder/index";
    }

    /**
     * 采购订单-新增
     * @param model
     * @return
     */
    @RequestMapping("/purchaseOrder/add")
    public String purchasingOrderAdd(Model model){
        return "purchaseOrder/add";
    }

    /**
     * 采购订单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/purchaseOrder/edit")
    public String purchaseOrderEdit(Model model,String purchaseOrderId ){
        model.addAttribute("purchaseOrderId", purchaseOrderId );
        return "purchaseOrder/edit";
    }

    /**
     * 采购订单-查看
     * @param model
     * @return
     */
    @RequestMapping("/purchaseOrder/open")
    public String purchaseOrderOpen(Model model,String purchaseOrderId ){
        model.addAttribute("purchaseOrderId", purchaseOrderId );
        return "purchaseOrder/open";
    }

    /**
     * 采购订单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/purchaseOrder/showTable")
    public String purchaseOrderShowTable(Model model,String dataIndex, String supplierId){
        model.addAttribute("supplierId", supplierId);
        model.addAttribute("dataIndex", dataIndex);
        return "purchaseOrder/showTable";
    }



    /**
     * 采购订单-编辑财务金额
     * @param model
     * @return
     */
    @RequestMapping("/purchaseOrder/editFinancialAmount")
    public String purchaseOrderEditFinancialAmount(Model model,String purchaseOrderId ){
        model.addAttribute("purchaseOrderId", purchaseOrderId );
        return "purchaseOrder/editFinancialAmount";
    }





    /**
     * 采购退货单-列表
     * @param model
     * @return
     */
    @RequestMapping("/purchaseReturn/index")
    public String purchaseReturnIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "purchaseReturn/index";
    }

    /**
     * 采购退货单-新增
     * @param model
     * @return
     */
    @RequestMapping("/purchaseReturn/add")
    public String purchaseReturnAdd(Model model){
        return "purchaseReturn/add";
    }

    /**
     * 采购退货单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/purchaseReturn/edit")
    public String purchaseReturnEdit(Model model,String proId ){
        model.addAttribute("proId",proId);
        return "purchaseReturn/edit";
    }

    /**
     * 采购退货单-查看
     * @param model
     * @return
     */
    @RequestMapping("/purchaseReturn/open")
    public String purchaseReturnOpen(Model model,String proId ){
        model.addAttribute("proId",proId);
        return "purchaseReturn/open";
    }

    /**
     * 采购退货单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/purchaseReturn/showTable")
    public String purchaseReturnShowTable(Model model,String dataIndex, String purchaseOrderId){
        model.addAttribute("purchaseOrderId", purchaseOrderId);
        model.addAttribute("dataIndex", dataIndex);
        return "purchaseReturn/showTable";
    }




    /**
     * 注文书管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/notesManagement/index")
    public String notesManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "notesManagement/index";
    }

    /**
     * 注文书管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/notesManagement/edit")
    public String notesManagementEdit(Model model,String ndid){
        model.addAttribute("ndid",ndid);
        return "notesManagement/edit";
    }


    /**
     * 注文书管理-生产采购订单
     * @param model
     * @return
     */
    @RequestMapping("/notesManagement/generatingOrders")
    public String notesManagementGeneratingOrders(Model model,String detailsId){
        model.addAttribute("detailsId",detailsId);
        return "notesManagement/generatingOrders";
    }







    /**
     * 采购交货期预警-列表
     * @param model
     * @return
     */
    @RequestMapping("/purchaseLeadTimeWarning/index")
    public String purchaseLeadTimeWarningIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "purchaseLeadTimeWarning/index";
    }






    /**
     * 产品结构清单-列表
     * @param model
     * @return
     */
    @RequestMapping("/listOfProductStructure/index")
    public String listOfProductStructureIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "listOfProductStructure/index";
    }

    /**
     * 产品结构清单-新增
     * @param model
     * @return
     */
    @RequestMapping("/listOfProductStructure/add")
    public String listOfProductStructureAdd(Model model){
        return "listOfProductStructure/add";
    }

    /**
     * 产品结构清单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/listOfProductStructure/edit")
    public String listOfProductStructureEdit(Model model,String bomId){
        model.addAttribute("bomId",bomId);
        return "listOfProductStructure/edit";
    }

    /**
     * 产品结构清单-查看
     * @param model
     * @return
     */
    @RequestMapping("/listOfProductStructure/open")
    public String listOfProductStructureOpen(Model model,String bomId){
        model.addAttribute("bomId",bomId);
        return "listOfProductStructure/open";
    }

    /**
     * 产品结构清单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/listOfProductStructure/showTable")
    public String listOfProductStructureShowTable(Model model,String dataIndex,String datatable1){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("datatable1",datatable1);
        return "listOfProductStructure/showTable";
    }






    /**
     * 生产指示书-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionInstructions/index")
    public String productionInstructionsIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionInstructions/index";
    }

    /**
     * 生产指示书-查看
     * @param model
     * @return
     */
    @RequestMapping("/productionInstructions/open")
    public String productionInstructionsOpen(Model model,String productionInstructionId){
        model.addAttribute("productionInstructionId",productionInstructionId);
        return "productionInstructions/open";
    }

    /**
     * 生产指示书-更新状态
     * @param model
     * @return
     */
    @RequestMapping("/productionInstructions/updateState")
    public String productionInstructionsUpdateState(Model model,String productionInstructionId){
        model.addAttribute("productionInstructionId",productionInstructionId);
        return "productionInstructions/updateState";
    }




    /**
     * 生产指示书明细-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionInstructionsDetailed/index")
    public String productionInstructionsDetailedIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionInstructionsDetailed/index";
    }






    /**
     * MRP运算-列表
     * @param model
     * @return
     */
    @RequestMapping("/MRPOperation/index")
    public String MRPOperationIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "MRPOperation/index";
    }

    /**
     * MRP运算-查看
     * @param model
     * @return
     */
    @RequestMapping("/MRPOperation/open")
    public String MRPOperationOpen(Model model){
        return "MRPOperation/open";
    }




    /**
     * 排产单-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionOrder/index")
    public String productionOrderIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionOrder/index";
    }

    /**
     * 排产单-新增
     * @param model
     * @return
     */
    @RequestMapping("/productionOrder/add")
    public String productionOrderAdd(Model model){
        return "productionOrder/add";
    }

    /**
     * 排产单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/productionOrder/edit")
    public String productionOrderEdit(Model model,String productionOrderId){
        model.addAttribute("productionOrderId",productionOrderId);
        return "productionOrder/edit";
    }

    /**
     * 排产单-查看
     * @param model
     * @return
     */
    @RequestMapping("/productionOrder/open")
    public String productionOrderOpen(Model model,String productionOrderId ){
        model.addAttribute("productionOrderId",productionOrderId );
        return "productionOrder/open";
    }

    /**
     * 排产单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/productionOrder/showTable")
    public String productionOrderShowTable(Model model,String dataIndex){
        model.addAttribute("dataIndex",dataIndex);
        return "productionOrder/showTable";
    }






    /**
     * 式样书-列表
     * @param model
     * @return
     */
    @RequestMapping("/styleBook/index")
    public String styleBookIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "styleBook/index";
    }

    /**
     * 式样书-新增
     * @param model
     * @return
     */
    @RequestMapping("/styleBook/add")
    public String styleBookAdd(Model model){
        return "styleBook/add";
    }

    /**
     * 式样书-编辑
     * @param model
     * @return
     */
    @RequestMapping("/styleBook/edit")
    public String styleBookEdit(Model model,String styleBookId){
        model.addAttribute("styleBookId",styleBookId);
        return "styleBook/edit";
    }

    /**
     * 式样书-查看
     * @param model
     * @return
     */
    @RequestMapping("/styleBook/open")
    public String styleBookOpen(Model model,String styleBookId){
        model.addAttribute("styleBookId",styleBookId);
        return "styleBook/open";
    }





    /**
     * 领料单-列表
     * @param model
     * @return
     */
    @RequestMapping("/pickingList/index")
    public String pickingListIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "pickingList/index";
    }

    /**
     * 领料单-新增
     * @param model
     * @return
     */
    @RequestMapping("/pickingList/add")
    public String pickingListAdd(Model model){
        return "pickingList/add";
    }

    /**
     * 领料单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/pickingList/edit")
    public String pickingListEdit(Model model,String pickingId){
        model.addAttribute("pickingId",pickingId);
        return "pickingList/edit";
    }

    /**
     * 领料单-查看
     * @param model
     * @return
     */
    @RequestMapping("/pickingList/open")
    public String pickingListOpen(Model model,String pickingId){
        model.addAttribute("pickingId",pickingId);
        return "pickingList/open";
    }


    /**
     * 领料单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/pickingList/showTable")
    public String pickingListShowTable(Model model,String dataIndex,String warehouseId){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("warehouseId",warehouseId);
        return "pickingList/showTable";
    }



    /**
     * 退料单-列表
     * @param model
     * @return
     */
    @RequestMapping("/returnOrder/index")
    public String returnOrderIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "returnOrder/index";
    }

    /**
     * 退料单-新增
     * @param model
     * @return
     */
    @RequestMapping("/returnOrder/add")
    public String returnOrderAdd(Model model){
        return "returnOrder/add";
    }

    /**
     * 退料单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/returnOrder/edit")
    public String returnOrderEdit(Model model, String refundPickingId){
        model.addAttribute("refundPickingId",refundPickingId);
        return "returnOrder/edit";
    }

    /**
     * 退料单-查看
     * @param model
     * @return
     */
    @RequestMapping("/returnOrder/open")
    public String returnOrderOpen(Model model, String refundPickingId){

        model.addAttribute("refundPickingId",refundPickingId);
        return "returnOrder/open";
    }

    /**
     * 退料单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/returnOrder/showTable")
    public String returnOrderShowTable(Model model,String dataIndex,String warehouseId){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("warehouseId",warehouseId);
        return "returnOrder/showTable";
    }







    /**
     * 排产单明细-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionOrderDetail/index")
    public String productionOrderDetailIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionOrderDetail/index";
    }





    /**
     * 生产日报-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionDaily/index")
    public String productionDailyIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionDaily/index";
    }




    /**
     * 生产领料明细-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionPickingDetails/index")
    public String productionPickingDetailsIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionPickingDetails/index";
    }




    /**
     * 生产计划分析-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionPlanAnalysis/index")
    public String productionPlanAnalysisIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionPlanAnalysis/index";
    }



    /**
     * 入库单-列表
     * @param model
     * @return
     */
    @RequestMapping("/inboundOrder/index")
    public String inboundOrderIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "inboundOrder/index";
    }

    /**
     * 入库单-新增
     * @param model
     * @return
     */
    @RequestMapping("/inboundOrder/add")
    public String inboundOrderAdd(Model model){
        return "inboundOrder/add";
    }

    /**
     * 入库单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/inboundOrder/edit")
    public String inboundOrderEdit(Model model){
        return "inboundOrder/edit";
    }

    /**
     * 入库单-查看
     * @param model
     * @return
     */
    @RequestMapping("/inboundOrder/open")
    public String inboundOrderOpen(Model model,String storageAccessId){
        model.addAttribute("storageAccessId",storageAccessId);
        return "inboundOrder/open";
    }

    /**
     * 入库单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/inboundOrder/showTable")
    public String inboundOrderShowTable(Model model ,String dataIndex){
        model.addAttribute("dataIndex",dataIndex);
        return "inboundOrder/showTable";
    }





    /**
     * 生产入库单-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionReceipt/index")
    public String productionReceiptIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionReceipt/index";
    }


    /**
     * 生产入库单-查看
     * @param model
     * @return
     */
    @RequestMapping("/productionReceipt/open")
    public String productionReceiptOpen(Model model,String productionEntryId){
        model.addAttribute("productionEntryId",productionEntryId);
        return "productionReceipt/open";
    }





    /**
     * 出库单-列表
     * @param model
     * @return
     */
    @RequestMapping("/outboundOrder/index")
    public String outboundOrderIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "outboundOrder/index";
    }

    /**
     * 出库单-新增
     * @param model
     * @return
     */
    @RequestMapping("/outboundOrder/add")
    public String outboundOrderAdd(Model model){
        return "outboundOrder/add";
    }

    /**
     * 出库单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/outboundOrder/edit")
    public String outboundOrderEdit(Model model){

        return "outboundOrder/edit";
    }

    /**
     * 出库单-查看
     * @param model
     * @return
     */
    @RequestMapping("/outboundOrder/open")
    public String outboundOrderOpen(Model model,String outboundOrderId){
        model.addAttribute("outboundOrderId",outboundOrderId);
        return "outboundOrder/open";
    }

    /**
     * 出库单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/outboundOrder/showTable")
    public String outboundOrderShowTable(Model model,String dataIndex,String warehouseId){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("warehouseId",warehouseId);
        return "outboundOrder/showTable";
    }





    /**
     * 库存盘点-列表
     * @param model
     * @return
     */
    @RequestMapping("/inventoryCheck/index")
    public String inventoryCheckIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "inventoryCheck/index";
    }

    /**
     * 库存盘点-新增
     * @param model
     * @return
     */
    @RequestMapping("/inventoryCheck/add")
    public String inventoryCheckAdd(Model model){
        return "inventoryCheck/add";
    }

    /**
     * 库存盘点-编辑
     * @param model
     * @return
     */
    @RequestMapping("/inventoryCheck/edit")
    public String inventoryCheckEdit(Model model){
        return "inventoryCheck/edit";
    }

    /**
     * 库存盘点-查看
     * @param model
     * @return
     */
    @RequestMapping("/inventoryCheck/open")
    public String inventoryCheckOpen(Model model, String inventoryCheckId){
        model.addAttribute("inventoryCheckId",inventoryCheckId);
        return "inventoryCheck/open";
    }

    /**
     * 库存盘点-showTable
     * @param model
     * @return
     */
    @RequestMapping("/inventoryCheck/showTable")
    public String inventoryCheckShowTable(Model model){
        return "inventoryCheck/showTable";
    }




    /**
     * 调拨单-列表
     * @param model
     * @return
     */
    @RequestMapping("/requisition/index")
    public String requisitionIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "requisition/index";
    }

    /**
     * 调拨单-新增
     //* @param model
     * @return
     */
    @RequestMapping("/requisition/add")
    public String requisitionAdd(Model mode){

        return "requisition/add";
    }

    /**
     * 调拨单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/requisition/edit")
    public String requisitionEdit(Model model,String requisitionId){
        model.addAttribute("requisitionId",requisitionId);
        return "requisition/edit";
    }

    /**
     * 调拨单-查看
     * @param model
     * @return
     */
    @RequestMapping("/requisition/open")
    public String requisitionOpen(Model model,String requisitionId){
        model.addAttribute("requisitionId",requisitionId);
        return "requisition/open";
    }

    /**
     * 调拨单-showTable
     * @param model
     * @return
     */
    @RequestMapping("/requisition/showTable")
    public String requisitionShowTable(Model model,String dataIndex,String outWarehouseId){
        model.addAttribute("dataIndex",dataIndex);
        model.addAttribute("outWarehouseId",outWarehouseId);
        return "requisition/showTable";
    }




    /**
     * 入库明细-列表
     * @param model
     * @return
     */
    @RequestMapping("/inboundDetails/index")
    public String inboundDetailsIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "inboundDetails/index";
    }




    /**
     * 出库明细-列表
     * @param model
     * @return
     */
    @RequestMapping("/outboundDetails/index")
    public String outboundDetailsIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "outboundDetails/index";
    }



    /**
     * 库存状态-列表
     * @param model
     * @return
     */
    @RequestMapping("/inventoryStatus/index")
    public String inventoryStatusIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "inventoryStatus/index";
    }


    /**
     * 库存余额表-列表
     * @param model
     * @return
     */
    @RequestMapping("/inventoryBalanceSheet/index")
    public String inventoryBalanceSheetIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "inventoryBalanceSheet/index";
    }


    /**
     * 库存余额表-查看
     * @param model
     * @return
     */
    @RequestMapping("/inventoryBalanceSheet/open")
    public String inventoryBalanceSheetOpen(Model model,String goodsId){
        model.addAttribute("goodsId",goodsId);
        return "inventoryBalanceSheet/open";
    }






    /**
     * 库存预警-列表
     * @param model
     * @return
     */
    @RequestMapping("/inventoryWarning/index")
    public String inventoryWarningIndex(Model model){
//        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
//        if(user==null||user.getPermissions()==null){
//            return "noAuthority/index";
//        }
//        List<StaffPermission> list = user.getPermissions();
//        for (StaffPermission adminPermission:list){
//            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
//        }
        return "inventoryWarning/index";
    }





    /**
     * 收款单-列表
     * @param model
     * @return
     */
    @RequestMapping("/receipt/index")
    public String receiptIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "receipt/index";
    }

    /**
     * 收款单-新增
     * @param model
     * @return
     */
    @RequestMapping("/receipt/add")
    public String receiptAdd(Model model){

        return "receipt/add";
    }

    /**
     * 收款单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/receipt/edit")
    public String receiptEdit(Model model , String receiptId){
        model.addAttribute("receiptId",receiptId);
        return "receipt/edit";
    }

    /**
     * 收款单-查看
     * @param model
     * @return
     */
    @RequestMapping("/receipt/open")
    public String receiptOpen(Model model, String receiptId){
        model.addAttribute("receiptId",receiptId);
        return "receipt/open";
    }




    /**
     * 付款单-列表
     * @param model
     * @return
     */
    @RequestMapping("/paymentSlip/index")
    public String paymentSlipIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "paymentSlip/index";
    }

    /**
     * 付款单-新增
     * @param model
     * @return
     */
    @RequestMapping("/paymentSlip/add")
    public String paymentSlipAdd(Model model){
        return "paymentSlip/add";
    }

    /**
     * 付款单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/paymentSlip/edit")
    public String paymentSlipEdit(Model model){
        return "paymentSlip/edit";
    }

    /**
     * 付款单-查看
     * @param model
     * @return
     */
    @RequestMapping("/paymentSlip/open")
    public String paymentSlipOpen(Model model,String paymentOrderId){
        model.addAttribute("paymentOrderId",paymentOrderId);
        return "paymentSlip/open";
    }





    /**
     * 工资单-列表
     * @param model
     * @return
     */
    @RequestMapping("/payroll/index")
    public String payrollIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "payroll/index";
    }

    /**
     * 工资单-新增
     * @param model
     * @return
     */
    @RequestMapping("/payroll/add")
    public String payrollAdd(Model model){
        return "payroll/add";
    }

    /**
     * 工资单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/payroll/edit")
    public String payrollEdit(Model model,String payrollId){

        model.addAttribute("payrollId",payrollId);
        return "payroll/edit";

    }

    /**
     * 工资单-查看
     * @param model
     * @return
     */
    @RequestMapping("/payroll/open")
    public String payrollOpen(Model model,String payrollId){

        model.addAttribute("payrollId",payrollId);
        return "payroll/open";
    }




    /**
     * 报销单-列表
     * @param model
     * @return
     */
    @RequestMapping("/reimbursementForm/index")
    public String reimbursementFormIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "reimbursementForm/index";
    }

    /**
     * 报销单-新增
     * @param model
     * @return
     */
    @RequestMapping("/reimbursementForm/add")
    public String reimbursementFormAdd(Model model){
        return "reimbursementForm/add";
    }

    /**
     * 报销单-编辑
     * @param model
     * @return
     */
    @RequestMapping("/reimbursementForm/edit")
    public String reimbursementFormEdit(Model model , String reimburseId){
        model.addAttribute("reimburseId",reimburseId);
        return "reimbursementForm/edit";
    }

    /**
     * 报销单-查看
     * @param model
     * @return
     */
    @RequestMapping("/reimbursementForm/open")
    public String reimbursementFormOpen(Model model, String reimburseId){
        model.addAttribute("reimburseId",reimburseId);
        return "reimbursementForm/open";
    }




    /**
     * 绩效管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/performanceManagement/index")
    public String performanceManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "performanceManagement/index";
    }




    /**
     * 货物管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/cargoManagement/index")
    public String cargoManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "cargoManagement/index";
    }

    /**
     * 货物管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/cargoManagement/add")
    public String cargoManagementAdd(Model model){
        return "cargoManagement/add";
    }

    /**
     * 货物管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/cargoManagement/edit")
    public String cargoManagementEdit(Model model,String goodsId){
        model.addAttribute("goodsId",goodsId);
        return "cargoManagement/edit";
    }

    /**
     * 货物管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/cargoManagement/open")
    public String cargoManagementOpen(Model model,String goodsId){
        model.addAttribute("goodsId",goodsId);
        return "cargoManagement/open";
    }




    /**
     * 品种管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/varietyManagement/index")
    public String varietyManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "varietyManagement/index";
    }

    /**
     * 品种管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/varietyManagement/add")
    public String varietyManagementAdd(Model model){
        return "varietyManagement/add";
    }

    /**
     * 品种管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/varietyManagement/edit")
    public String varietyManagementEdit(Model model,String varietyValue){
        model.addAttribute("varietyValue",varietyValue);
        return "varietyManagement/edit";
    }





    /**
     * 仓库管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/warehouseManagement/index")
    public String warehouseManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "warehouseManagement/index";
    }

    /**
     * 仓库管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/warehouseManagement/add")
    public String warehouseManagementAdd(Model model){

        return "warehouseManagement/add";
    }

    /**
     * 仓库管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/warehouseManagement/edit")
    public String warehouseManagementEdit(Model model,String warehouseId){
        model.addAttribute("warehouseId",warehouseId);
        return "warehouseManagement/edit";
    }

    /**
     * 仓库管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/warehouseManagement/open")
    public String warehouseManagementOpen(Model model,String warehouseId){
        model.addAttribute("warehouseId",warehouseId);
        return "warehouseManagement/open";
    }





    /**
     * 仓位管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/positionManagement/index")
    public String positionManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "positionManagement/index";
    }

    /**
     * 仓位管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/positionManagement/add")
    public String positionManagementAdd(Model model){
        return "positionManagement/add";
    }

    /**
     * 仓位管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/positionManagement/edit")
    public String positionManagementEdit(Model model,String wpId){
        model.addAttribute("wpId",wpId);
        return "positionManagement/edit";
    }

    /**
     * 仓位管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/positionManagement/open")
    public String positionManagementOpen(Model model,String wpId){
        model.addAttribute("wpId",wpId);
        return "positionManagement/open";
    }





    /**
     * 供应商管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/supplierManagement/index")
    public String supplierManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "supplierManagement/index";
    }

    /**
     * 供应商管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/supplierManagement/add")
    public String supplierManagementAdd(Model model){
        return "supplierManagement/add";
    }

    /**
     * 供应商管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/supplierManagement/edit")
    public String supplierManagementEdit(Model model,String supplierId){
        model.addAttribute("supplierId",supplierId);
        return "supplierManagement/edit";
    }

    /**
     * 供应商管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/supplierManagement/open")
    public String supplierManagementOpen(Model model,String supplierId){
        model.addAttribute("supplierId",supplierId);
        return "supplierManagement/open";
    }






    /**
     * 员工管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/employeeManagement/index")
    public String employeeManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "employeeManagement/index";
    }

    /**
     * 员工管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/employeeManagement/add")
    public String employeeManagementAdd(Model model){
        return "employeeManagement/add";
    }

    /**
     * 员工管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/employeeManagement/edit")
    public String employeeManagementEdit(Model model, String staffId){

        model.addAttribute("staffId",staffId);
        return "employeeManagement/edit";
    }

    /**
     * 员工管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/employeeManagement/open")
    public String employeeManagementOpen(Model model, String staffId){
        model.addAttribute("staffId",staffId);
        return "employeeManagement/open";
    }

    /**
     * 员工管理-经验值管理
     * @param model
     * @return
     */
    @RequestMapping("/employeeManagement/popupPage1")
    public String employeeManagementPopupPage1(Model model, String staffId){
        model.addAttribute("staffId",staffId);
        return "employeeManagement/popupPage1";
    }

    /**
     * 员工管理-调岗记录
     * @param model
     * @return
     */
    @RequestMapping("/employeeManagement/popupPage2")
    public String employeeManagementPopupPage2(Model model, String staffId){
        model.addAttribute("staffId",staffId);
        return "employeeManagement/popupPage2";
    }




    /**
     * 客户管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/customerManagement/index")
    public String customerManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "customerManagement/index";
    }

    /**
     * 客户管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/customerManagement/add")
    public String customerManagementAdd(Model model){
        return "customerManagement/add";
    }

    /**
     * 客户管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/customerManagement/edit")
    public String customerManagementEdit(Model model, String customerId){
        model.addAttribute("customerId",customerId);
        return "customerManagement/edit";
    }

    /**
     * 客户管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/customerManagement/open")
    public String customerManagementOpen(Model model, String customerId){
        model.addAttribute("customerId",customerId);
        return "customerManagement/open";
    }





    /**
     * 数据字典-列表
     * @param model
     * @return
     */
    @RequestMapping("/dataDictionary/index")
    public String dataDictionaryIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "dataDictionary/index";
    }

    /**
     * 数据字典-新增
     * @param model
     * @return
     */
    @RequestMapping("/dataDictionary/add")
    public String dataDictionaryAdd(Model model,String parentId){
        model.addAttribute("parentId",parentId);
        return "dataDictionary/add";
    }

    /**
     * 数据字典-编辑
     * @param model
     * @return
     */
    @RequestMapping("/dataDictionary/edit")
    public String dataDictionaryEdit(Model model,String id){
        model.addAttribute("id",id);
        return "dataDictionary/edit";
    }





    /**
     * 材料需求清单-列表
     * @param model
     * @return
     */
    @RequestMapping("/materialRequirementsList/index")
    public String materialRequirementsListIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "materialRequirementsList/index";
    }



    /**
     * 在产产值估算-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionValueEstimate/index")
    public String productionValueEstimateIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionValueEstimate/index";
    }



    /**
     * 生产成本计算-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionCostCalculation/index")
    public String productionCostCalculationIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionCostCalculation/index";
    }



    /**
     * 销售分析-列表
     * @param model
     * @return
     */
    @RequestMapping("/salesAnalysis/index")
    public String salesAnalysisIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "salesAnalysis/index";
    }




    /**
     * 入库出库分析表-列表
     * @param model
     * @return
     */
    @RequestMapping("/outboundDatabaseAnalysisTable/index")
    public String outboundDatabaseAnalysisTableIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "outboundDatabaseAnalysisTable/index";
    }





    /**
     * 生产进度分析-列表
     * @param model
     * @return
     */
    @RequestMapping("/productionScheduleAnalysis/index")
    public String productionScheduleAnalysisIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "productionScheduleAnalysis/index";
    }




    /**
     * 权限管理-列表
     * @param model
     * @return
     */
    @RequestMapping("/authorityManagement/index")
    public String authorityManagementIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "authorityManagement/index";
    }

    /**
     * 权限管理-新增
     * @param model
     * @return
     */
    @RequestMapping("/authorityManagement/add")
    public String authorityManagementAdd(Model model){
        return "authorityManagement/add";
    }

    /**
     * 权限管理-编辑
     * @param model
     * @return
     */
    @RequestMapping("/authorityManagement/edit")
    public String authorityManagementEdit(Model model,String groupId){
        model.addAttribute("groupId",groupId);
        return "authorityManagement/edit";
    }

    /**
     * 权限管理-查看
     * @param model
     * @return
     */
    @RequestMapping("/authorityManagement/open")
    public String authorityManagementOpen(Model model,String groupId){
        model.addAttribute("groupId",groupId);
        return "authorityManagement/open";
    }






    /**
     * 管理员列表-列表
     * @param model
     * @return
     */
    @RequestMapping("/administratorList/index")
    public String administratorListIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "administratorList/index";
    }

    /**
     * 管理员列表-新增
     * @param model
     * @return
     */
    @RequestMapping("/administratorList/add")
    public String administratorListAdd(Model model){
        return "administratorList/add";
    }

    /**
     * 管理员列表-编辑
     * @param model
     * @return
     */
    @RequestMapping("/administratorList/edit")
    public String administratorListEdit(Model model){
        return "administratorList/edit";
    }







    /**
     * 权限表-列表
     * @param model
     * @return
     */
    @RequestMapping("/permissionTable/index")
    public String permissionTableIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "permissionTable/index";
    }

    /**
     * 权限表-新增
     * @param model
     * @return
     */
    @RequestMapping("/permissionTable/add")
    public String permissionTableAdd(Model model, String accessModuleId){
        model.addAttribute("accessModuleId",accessModuleId);
        return "permissionTable/add";
    }

    /**
     * 权限表-编辑
     * @param model
     * @return
     */
    @RequestMapping("/permissionTable/edit")
    public String permissionTableEdit(Model model,String accessId){
        model.addAttribute("accessId",accessId);
        return "permissionTable/edit";
    }




    /**
     * 系统参数设置-列表
     * @param model
     * @return
     */
    @RequestMapping("/systemParameterSetting/index")
    public String systemParameterSettingIndex(Model model){
        Staff user =(Staff) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.getPermissions()==null){
            return "noAuthority/index";
        }
        List<StaffPermission> list = user.getPermissions();
        for (StaffPermission adminPermission:list){
            model.addAttribute(adminPermission.getPermissions(),adminPermission.getUrl());
        }
        return "systemParameterSetting/index";
    }



    /**
     * 404页面
     * @param model
     * @return
     */
    @RequestMapping("/noAuthority/index")
    public String noAuthorityIndex(Model model){

        return "noAuthority/index";
    }






}
