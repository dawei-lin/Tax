package nsfw.reserve.service.impl;

import javax.annotation.Resource;

import nsfw.reserve.dao.ReserveDao;
import nsfw.reserve.entity.Reserve;
import nsfw.reserve.service.ReserveService;

import org.springframework.stereotype.Component;

import core.service.impl.BaseServiceImpl;
@Component("reserveService")
public class ReserveServiceImpl extends BaseServiceImpl<Reserve> implements
		ReserveService {
	private ReserveDao reserveDao;
	@Resource
	public void setReserveDao(ReserveDao reserveDao) {
		this.setBaseDao(reserveDao);
		this.reserveDao = reserveDao;
	}
}
