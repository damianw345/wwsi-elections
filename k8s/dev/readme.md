# Use to run application on local dev environment via minikube

# prerequisites
1. install Docker
1. install minikube

# steps to run
1. `minikube start`
1. in project's root dir `docker build -t elections-server:dev .`
1. in src/js/elections `docker build -t elections:dev . `
1. `eval $(minikube docker-env)`
1. `kubectl apply -f elections-server-dev.yml`
1. `kubectl apply -f elections-dev.yml`
1. `minikube tunnel`
1. optionally: run `minikube dashboard` to see Kubernetes dashboard in your browser
1. in case there were http 504 after trying to login on webpage try to restart minikube 
   cluster: `minikube stop && minikube start` and try again

