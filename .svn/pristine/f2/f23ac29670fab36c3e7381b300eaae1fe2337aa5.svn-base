package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.NoteDocument;
import com.mingyuansoftware.aifactory.model.dto.NoteDocumentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Service
public interface NoteDocumentMapper {
    int deleteByPrimaryKey(Integer ndid);

    int insert(NoteDocument record);

    NoteDocument selectByPrimaryKey(Integer ndid);

    List<NoteDocument> selectAll();

    int updateByPrimaryKey(NoteDocument record);

    /**
     * 注文书列表
     * @param noteDocumentDto
     * @return
     */
    List<NoteDocumentDto> selectNoteDocumentList(@Param("noteDocumentDto") NoteDocumentDto noteDocumentDto);

    /**
     * 注文书列表总条数
     * @param noteDocumentDto
     * @return
     */
    int selectCount(@Param("noteDocumentDto") NoteDocumentDto noteDocumentDto);

    /**
     * 查询注文书能否更新操作(只有未生成采购订单的注文书才可以更新操作)注文书状态为 1.无采购
     * @param ndid
     * @return
     */
    int selectUpdateNoteDocumentInfo(@Param("ndid") int ndid);

    /**
     * 使用注文书id修改注文书状态为:2.采购中;添加采购订单id
     * @param ndid
     * @param purchaseOrderId
     */
    void updateNdStatusById(@Param("ndid") Integer ndid,@Param("purchaseOrderId") int purchaseOrderId,@Param("state") int state);

    /**
     * 使用采购订单id修改注文书状态3.退换货
     * @param purchaseOrderId
     * @param state
     */
    void updateNdStatusByPurchaseOrderId(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("state") int state);

    /**
     * 根据采购订单id查询注文书(状态)
     * @param purchaseOrderId
     * @return
     */
    List<NoteDocument> selectByPurhcaseOrderId(@Param("purchaseOrderId") Integer purchaseOrderId);

    /**
     * 根据货物Id和单价查询注文书
     * @param goodsId
     * @param price
     * @param total
     * @return
     */
    NoteDocument selectNoteDocumentByGoodsId(@Param("goodsId") Integer goodsId,@Param("price") BigDecimal price,@Param("total") BigDecimal total);

    /**
     * 根据注文书id查询注文书中的货物信息
     * @param ndid
     * @return
     */
    NoteDocumentDto selectGoodInfoByNote(@Param("ndid") Integer ndid);

    /**
     * 根据货物Id查询注文书中的所有货物数量的和
     * @param goodsId
     * @return
     */
    NoteDocument selectAllCountByGoodsId(@Param("goodsId") Integer goodsId, @Param("state") int state);

    /**
     * 根据货物id修改注文书中货物发注残
     * @param count
     * @param goodsId
     */
    void updateCountByGoodsId(@Param("count") BigDecimal count,@Param("goodsId") Integer goodsId, @Param("state") int state);

    /**
     * 根据货物Id和注文书查询数据(数量之和,合计金额之和)
     * @param goodsId
     * @param ndStatus
     * @return
     */
    NoteDocument selectNoteDocumentInfo(@Param("goodsId") Integer goodsId,@Param("ndStatus") Byte ndStatus);

    /**
     * 根据货物id和注文书状态查询需要删除的注文书id
     * @param goodsId
     * @param ndStatus
     * @return
     */
    List<Integer> selectNoteDocumentId(@Param("goodsId") Integer goodsId, @Param("ndStatus") Byte ndStatus);

    /**
     * 根据注文书Id修改注文书引当残
     * @param ndid
     * @param goodsId
     * @param yinDangCan
     */
    void updateYDCByNdId(@Param("ndid") Integer ndid, @Param("goodsId") Integer goodsId, @Param("yinDangCan") BigDecimal yinDangCan);

    /**
     * 根据注文书Id修改注文不足或多余在库
     * @param ndid
     * @param annotation
     */
    void updateAnnoByNdId(@Param("ndid") Integer ndid, @Param("goodsId") Integer goodsId, @Param("annotation") BigDecimal annotation);
}