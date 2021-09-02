import requests
import time

#Change these values the way you want them to be
my_id="g182887493423220268791337"
skull_amount="99999"
orange_skull="9999"
soul_amount="999"
sword_level="9"

url="http://tower-breaker-backup.ap-northeast-2.elasticbeanstalk.com/backup/"+my_id+"/"

###new=2#0#1/0|0/0|0/0|0/0|1/0|1/0|1/0|1/0|0/0|0/0|0/0|0/0|#False#False#False#False#False##7#4#0#True#False#False#False#False#True#True#True#True#29#1#221#1#True#True#False#False#True#602#0#True#True#True#True#True#True#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#26|3/27|2/1|1100/17740|5190|231|335|51|723|5|2|1|1|0|0|0|0|147|59|67|72|33|0|0|0|48|810|1|2|4|14|13|0|0|12|46|11|29|114|25|0|71|#30#600#0#1/0|0/0|1/0|0/0|1/0|0/0|1/0|0/0|0/0|0/0|0/0|0/0|#489#144#True#True#True#True#True#True#True#True#True#True#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#True#True#0/3/1/0/2/0/SPEAR_NAME_HELL_T1/11/63.4/95/87.3/0.0665/0.133/0.09979807/16/3176/0/-1|#False#False#False#False#False#False#False#True#0#False#False#False#False#False#0#0#0#1#0#1#1#0#0#1#1#2#1#1#0#0#0#0#0#2#False#False#False#11#0#&saved_at=10/21/2019+17:19:30
#old=2#0#1/0|0/0|0/0|0/0|0/0|0/0|0/0|1/0|0/0|0/0|0/0|0/0|#False#False#False#False#False##7#4#0#False#False#False#False#False#True#True#True#True#"+orange_skull+"#0#110#0#False#False#False#False#False#113#-1#True#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#35|15/38|25/6|1/13201|5137|192|130|32|196|1|2|0|0|0|0|0|0|223|55|69|68|0|0|0|0|87|222|0|0|4|4|4|0|0|30|154|6|17|317|48|0|108|#10#100#0#1/0|0/0|0/0|0/0|1/0|0/0|0/0|0/0|0/0|0/0|0/0|0/0|#"+skull_amount+"#"+soul_amount+"#True#True#True#True#True#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#True#True#0/2/0/3/0/0/SWORD_NAME_LEGENDARY_T0/"+sword_level+"/25.2/37.8/37/0.039/0.088/0.06254561/6/227/0/-1|#False#False#False#False#False#False#False#True#0#False#False#False#False#False#0#0#0#0#0#1#0#0#0#1#1#1#1#0#0#0#0#0#0#0#False#False#False#5#0#&saved_at=

data="2#0#1/0|0/0|0/0|0/0|1/0|1/0|1/0|1/0|0/0|0/0|0/0|0/0|#False#False#False#False#False##7#4#0#True#False#False#False#False#True#True#True#True#"+orange_skull+"#0#110#0#False#False#False#False#False#113#-1#True#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#35|15/38|25/6|1/13201|5137|192|130|32|196|1|2|0|0|0|0|0|0|223|55|69|68|0|0|0|0|87|222|0|0|4|4|4|0|0|30|154|6|17|317|48|0|108|#10#100#0#1/0|0/0|0/0|0/0|1/0|0/0|0/0|0/0|0/0|0/0|0/0|0/0|#"+skull_amount+"#"+soul_amount+"#True#True#True#True#True#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#False#True#True#0/2/0/3/0/0/SWORD_NAME_LEGENDARY_T0/"+sword_level+"/25.2/37.8/37/0.039/0.088/0.06254561/6/227/0/-1|#False#False#False#False#False#False#False#True#0#False#False#False#False#False#0#0#0#0#0#1#0#0#0#1#1#1#1#0#0#0#0#0#0#0#False#False#False#5#0#&saved_at="

headers={
"X-Unity-Version": "5.6.5p4",
"Content-Type": "application/x-www-form-urlencoded",
"User-Agent": "Dalvik/2.1.0 (Linux; U; Android 9; SM-G950F Build/PPR1.180610.011)",
"Host": "tower-breaker-backup.ap-northeast-2.elasticbeanstalk.com",
"Connection": "Keep-Alive",
"Accept-Encoding": "gzip",
"Proxy-Authorization": "Basic YWk2MDEuYXNhci5tZTp5b2pxcmRuag=="
}
formatted_time=time.strftime("%m/%d/%Y+%H:%M:%S")

r=requests.post(url,data="content="+data+formatted_time,headers=headers)
print r.content