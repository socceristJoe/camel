package com.joepoccamel.camelmicroserviceb.routes.ActiveMqReceiver;

public class ApimEnvBean {
    private String dev;
    private String nonprod;
    private String prod;

    public ApimEnvBean() {
    }

    public ApimEnvBean(String dev, String nonprod, String prod) {
        super();
        this.dev = dev;
        this.nonprod = nonprod;
        this.prod = prod;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getNonprod() {
        return nonprod;
    }

    public void setNonprod(String nonprod) {
        this.nonprod = nonprod;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    @Override
    public String toString() {
        return "ApimEnvBean{" +
                "dev='" + dev + '\'' +
                ", nonprod='" + nonprod + '\'' +
                ", prod='" + prod + '\'' +
                '}';
    }
}
