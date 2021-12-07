import os
import getpass as gp

LOCAL_USER = gp.getuser()
#WORKER = os.system("curl -s 'https://issues.feedzai.com/rest/api/2/user?username='LOCAL_USER -H 'content-type: application/json'")

test = "this is" + LOCAL_USER

print(test)
