package project.management.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import project.management.entity.OrderItemProductEntity;

public class OrderItemProductMapper implements RowMapper<OrderItemProductEntity> {

	@Override
	public OrderItemProductEntity mapRow(ResultSet rs) {
		try {
			OrderItemProductEntity orderItemEntity = new OrderItemProductEntity();
			orderItemEntity.setId(rs.getInt("id"));
			orderItemEntity.setOrderid(rs.getInt("orderitemid"));
			orderItemEntity.setProductid(rs.getInt("productid"));
			orderItemEntity.setCountOrdered(rs.getInt("count"));
			return orderItemEntity;
		} catch (SQLException e) {
			return null;
		}
	}

}
