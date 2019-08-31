####docker run 
**-p** - ports (-p 3306:3306)

**-e** - environment variable (-e MYSQL_ROOT_PASSWORD=r00t)

**-d** - detached. This parameter does not block the terminal

**--name** - name of the container. Container will be accessible by tis name (--name spring)

**--network** - assign container to specific network (--network network_1). Network must be created by the corresponding command

**-it** - interactive. Get container console. 'exit' after will quit from container console. Required 'sh' in the end of 'docker run' command expression

####docker network
**docker network ps** - see all networks

**docker network create network_1** - create network with name 'network_1'

**docker network rm network_1** - remove network with name 'network_1'

####docker build
**docker build** - build docker image based on Dockerfile   

**-t <image_name>**
 
**-f Dockerfile** - pass in Dockerfile file location + name

**.** - command should end with dot. Specifies the 'context'. Can be passed different location instead of dot

_(docker build -f Dockerfile -t spring .)_

####docker-compose
**docker-compose -f docker-compose.yaml up --build -d**

**docker-compose -f docker-compose.yaml down**