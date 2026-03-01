# Run the image with the command: docker build -t dosimg . && docker run --rm -p 8080:8080 dosimg
# Then got to http://localhost:8080/vnc.html
FROM ubuntu:22.04

# Install DOSBox and a light VNC server
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y \
    dosbox \
    x11vnc \
    xvfb \
    novnc \
    websockify \
    && apt-get clean

# Create the folder for QBasic
WORKDIR /app
COPY bin/QB.EXE .
COPY src/* .

RUN echo '#!/bin/bash\n\
# 1. Create a DOSBox config to avoid a crash\n\
mkdir -p /root/.dosbox\n\
echo "[sdl]\noutput=surface\n[cpu]\ncore=normal\ncputype=386" > /root/.dosbox/dosbox-0.74-3.conf\n\
\n\
# 2. Run the displaying server\n\
Xvfb :1 -screen 0 800x600x16 &\n\
export DISPLAY=:1\n\
sleep 2\n\
\n\
# 3. Run the web bridge (when using noVNC)\n\
x11vnc -forever -create -nopw -display :1 &\n\
/usr/share/novnc/utils/launch.sh --vnc localhost:5900 --listen 8080 &\n\
\n\
# 4. Run DOSBox\n\
dosbox -c "mount c /app" -c "c:" -c "QB.EXE /run CHATEAU1.BAS" -c "exit"\n\
' > /app/run.sh && chmod +x /app/run.sh

EXPOSE 8080
CMD ["/app/run.sh"]
