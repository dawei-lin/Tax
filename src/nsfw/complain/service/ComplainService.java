package nsfw.complain.service;

import java.util.List;
import java.util.Map;

import nsfw.complain.entity.Complain;
import core.service.BaseService;

public interface ComplainService extends BaseService<Complain> {
	public void autoDeal();

	public List<Map> getAnnualStatistic(int year);
}
