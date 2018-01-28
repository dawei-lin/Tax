package nsfw.reserve.service.impl;

import javax.annotation.Resource;

import nsfw.reserve.dao.ReserveItemDao;
import nsfw.reserve.entity.ReserveItem;
import nsfw.reserve.service.ReserveItemService;

import org.springframework.stereotype.Component;

import core.service.impl.BaseServiceImpl;
@Component("reserveItemService")
public class ReserveItemServiceImpl extends BaseServiceImpl<ReserveItem>
		implements ReserveItemService {
	private ReserveItemDao reserveItemDao;
	@Resource
	public void setReserveItemDao(ReserveItemDao reserveItemDao) {
		this.setBaseDao(reserveItemDao);
		this.reserveItemDao = reserveItemDao;
	}
}
