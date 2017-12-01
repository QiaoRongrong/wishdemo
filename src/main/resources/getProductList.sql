select id,isSid,renewal,bespoke,code,simpleName,rate,deadline,amount,alreadyRaiseAmount,status,isShow,isHot,fid,startDate,surplusDay
		from (
			select dpi1.*,case when DATEDIFF(dpi1.expireDate,SYSDATE())>0 then DATEDIFF(dpi1.expireDate,SYSDATE()) else 0 end as surplusDay,
			(select fid from dr_product_info dpi2 where dpi2.fid = dpi1.id and dpi2.`status` !=4) renewal,
		case when dpi1.startDate>SYSDATE() then 1 else 0 end bespoke
from dr_product_info dpi1) dpi