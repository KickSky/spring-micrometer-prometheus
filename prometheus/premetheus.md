docker build -t my-prometheus .
docker run -d --name prometheus -p 9090:9090 my-prometheus