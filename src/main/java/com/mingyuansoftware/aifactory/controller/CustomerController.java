package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.CustomerContact;
import com.mingyuansoftware.aifactory.model.dto.CustomerDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.CustomerContactService;
import com.mingyuansoftware.aifactory.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 张婷
 * @date 2019/6/27 9:51
 */

@RestController
@Api(value = "customer-api", description = "客户列表", tags = {"客户管理-客户列表"})
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerContactService customerContactService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "customerDto", value = "客户参数实体类", paramType = "query", dataType = "CustomerDto"),
    })
    @ApiOperation(value = "客户列表", nickname = "selectCustomerList", notes = "客户列表", tags = {"@张婷"})
    @RequestMapping(value = "/selectCustomerList", method = RequestMethod.GET)
    @RequiresPermissions(value = {"selectCustomerList"})
    public LayuiCommonResponse selectCustomerList(@Validated @RequestParam(defaultValue = "1") int page, @Validated @RequestParam(defaultValue = "10") int limit,
                                                  @Validated CustomerDto customerDto) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<Customer> selectCustomerAll = customerService.selectCustomerAll(customerDto);
            Integer count = customerService.count(customerDto);

            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setData(selectCustomerAll);
            layuiCommonResponse.setCount(count);
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "查看客户信息", nickname = "selectCustomerDetailByCId", notes = "查看客户信息", tags = {"@张婷"})
    @ApiImplicitParam(name = "customerId", value = "客户id", required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/selectCustomerDetailByCId", method = RequestMethod.GET)
    public LayuiCommonResponse selectCustomerDetailByCId(Integer customerId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Customer customer = customerService.selectCustomerByCId(customerId);
            layuiCommonResponse.setData(customer);
            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }

   /* @ApiOperation(value = "获取客户联系人列表", nickname = "getCustomerContactList", notes = "获取客户联系人一条列表,用于添加数据", tags = {"@张婷"})
    @ApiImplicitParam(name = "customerContactId", value = "客户联系人id", paramType = "query", dataType = "int")
    @RequestMapping(value = "/customerContactList", method = RequestMethod.GET)
    public LayuiCommonResponse customerContactList(Integer customerContactId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            List<CustomerContact> customerContactList = customerContactService.customerContactList(customerContactId);
            layuiCommonResponse.setData(customerContactList);
            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }

        return layuiCommonResponse;
    }*/

    @ApiOperation(value = "添加客户", nickname = "addCustomerDetail", notes = "添加客户", tags = {"@张婷"})
    @ApiImplicitParam(name = "customer", value = "客户实体类", required = true, dataType = "Customer")
    @RequestMapping(value = "/addCustomerDetail", method = RequestMethod.POST)
    @RequiresPermissions(value = {"addCustomerDetail"})
    public LayuiCommonResponse addCustomerDetail(@RequestBody Customer customer) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer customerList = customerService.addCustomer(customer);
            if (customerList < 1) {
                layuiCommonResponse.setCode(ZtCode.FAIL_ADD.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_ADD.getInfo());
                return layuiCommonResponse;
            }
            layuiCommonResponse.setCode(ZtCode.SUCCESS_ADD.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_ADD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_ADD.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_ADD.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "编辑客户", nickname = "editCustomer", notes = "编辑客户", tags = {"@张婷"})
    @ApiImplicitParam(name = "customer", value = "客户信息", dataType = "Customer")
    @RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
    @RequiresPermissions(value = {"editCustomer"})
    public LayuiCommonResponse editCustomer(@RequestBody Customer customer) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer editCustomer = customerService.editCustomer(customer);
            if (editCustomer < 1) {
                layuiCommonResponse.setCode(ZtCode.FAIL_EDIT.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_EDIT.getInfo());
                return layuiCommonResponse;
            }
            layuiCommonResponse.setCode(ZtCode.SUCCESS_EDIT.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_EDIT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_EDIT.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_EDIT.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "删除客户", nickname = "deleteCustomer", notes = "逻辑删除客户和客户联系人信息", tags = {"@张婷"})
    @ApiImplicitParam(name = "customerId", value = "客户id", required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteCustomer"})
    public LayuiCommonResponse deleteCustomer(Integer customerId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer deleteCustomer = customerService.deleteCustomer(customerId);
            if (deleteCustomer < 1) {
                layuiCommonResponse.setCode(ZtCode.FAIL_DELETE.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_DELETE.getInfo());
                return layuiCommonResponse;
            }
            layuiCommonResponse.setCode(ZtCode.SUCCESS_DELETE.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_DELETE.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_DELETE.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_DELETE.getInfo());
        }
        return layuiCommonResponse;
    }

}
