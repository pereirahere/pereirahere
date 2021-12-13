# Imports
import requests
import getpass as gp

# Default Variables
local_user = str(gp.getuser())
url_user = 'https://issues.feedzai.com/rest/api/2/user?username=' + local_user
pw_loc = '/fz/info/jira_pw.txt'
pw = open(r"/home/" + local_user + pw_loc).readlines()[0].rstrip('\n')

r = requests.get(url_user, headers={'content-type':'application/json'}, auth=(local_user, pw))

print(r.status_code)



