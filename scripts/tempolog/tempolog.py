import requests
import getpass as gp

local_user = gp.getuser()
url= 'https://issues.feedzai.com/rest/api/2/user?username=' + local_user
header = {'Content-Type':'application/json','Accept':'application/json'}
payload = {'username' : local_user}

def fetch_pass():
    return open(r"/home/" + local_user + "/fz/info/jira_pw.txt").readlines()[0]


#def fetch_work():
#    return os.system('curl -s https://issues.feedzai.com/rest/api/2/user?username=' + local_user + ' -H content-type: application/json -u ' + local_user + ':' + pass_user + ' > /dev/null 2>&1')

print(local_user, fetch_pass())
r = requests.get(url, headers={"content-type":"json"}, auth=(local_user, fetch_pass))

print(r.url)
print(r.status_code)