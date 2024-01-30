/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.petronet.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.petronet.model.CafeInventory;
import com.petronet.model.CafeteriaCouponDetails;
import com.petronet.service.base.CafeteriaCouponDetailsLocalServiceBaseImpl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.petronet.model.CafeteriaCouponDetails",
	service = AopService.class
)
public class CafeteriaCouponDetailsLocalServiceImpl
	extends CafeteriaCouponDetailsLocalServiceBaseImpl {
	private static final Log _log = LogFactoryUtil.getLog(CafeteriaCouponDetailsLocalServiceImpl.class);

	@Override
	public CafeteriaCouponDetails addCafeteriaCouponDetails(long empId ,long companyId,long groupId ,String eName,String requestFor,String item ,long availQty,long reqQty,long itemVal ) {
		CafeteriaCouponDetails cafeteriaCouponDetails=null;
		_log.info("CafeteriaCouponDetailsLocalServiceImpl...");
		long cafId = counterLocalService.increment(CafeteriaCouponDetails.class.getName());
		cafeteriaCouponDetails = cafeteriaCouponDetailsPersistence.create(cafId);
		cafeteriaCouponDetails.setCafId(cafId);
		cafeteriaCouponDetails.setGroupId(groupId);
		cafeteriaCouponDetails.setCompanyId(companyId);
		cafeteriaCouponDetails.setUserId(empId);
		cafeteriaCouponDetails.setCreateDate(new Date());
		cafeteriaCouponDetails.setEmplooyeeName(eName);
		cafeteriaCouponDetails.setReqFor(requestFor);
		cafeteriaCouponDetails.setItem(item);
		cafeteriaCouponDetails.setItemQuantity(availQty);
		cafeteriaCouponDetails.setItemValue(itemVal);
		
		cafeteriaCouponDetailsPersistence.update(cafeteriaCouponDetails);
		
		return cafeteriaCouponDetails;
	}
	
	@Override
	public List<CafeteriaCouponDetails> getCafeteriaDetailsByItem(String item ){
		try {
	        return cafeteriaCouponDetailsPersistence.findByitemAndInv(item);
	    } catch (Exception e) {
	        _log.error("Error while fetching CafeInventory by item name: " + item, e);
	        return Collections.emptyList();
	    }
	}
	
	@Override
	public List<CafeteriaCouponDetails> getCafeteriaCouponDetailses(int start, int end) {
		return super.getCafeteriaCouponDetailses(start, end);
	}
	
	
	@Override
	public List<CafeteriaCouponDetails> getByUserId(long userId) {
		return cafeteriaCouponDetailsPersistence.findByBYuserId(userId);
	}
	@Override
	public List<CafeteriaCouponDetails> getByUserIdAndDate(long userId, int month, int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.MONTH, month - 1); 
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.DAY_OF_MONTH, 1); 

	    Date startDate = calendar.getTime();

	    calendar.add(Calendar.MONTH, 1); 
	    Date endDate = calendar.getTime();

	    DynamicQuery dynamicQuery = dynamicQuery();

	    dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
	    dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", startDate));
	    dynamicQuery.add(RestrictionsFactoryUtil.lt("createDate", endDate));

	    return cafeteriaCouponDetailsLocalService.dynamicQuery(dynamicQuery);
	}
	
	@Override
    public List<CafeteriaCouponDetails> getAmountByUserIdAndCurrentMonth(long userId) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        LocalDate startOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

        return cafeteriaCouponDetailsPersistence.findByBYuserId(userId, currentMonth, currentYear);
    }
	
}