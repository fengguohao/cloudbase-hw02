package com.cloudbase.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author fguohao
 * @date 2021/07/12
 */
public class AlwaysFirstLoadBalanceRule extends AbstractLoadBalancerRule {
    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> servers = loadBalancer.getReachableServers();
        if (servers.isEmpty()) {
            return null;
        }else{
            System.out.println(servers.get(0).getPort());
            return servers.get(0);
        }
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
