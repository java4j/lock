package com.java4j.lock.testsynchronized;

/**
 * 使用synchronized进行卖票
 *
 * @author java4j
 */
public class TicketService {

    /**
     * 票的总数量
     */
    private int sumTickets;

    public TicketService(int sumTickets) {
        this.sumTickets = sumTickets;
    }

    public synchronized boolean saleTicket() {
        if (sumTickets > 0) {
            System.out.println(Thread.currentThread().getName() + "开始卖票，卖票成功，剩余票数：" + --sumTickets);
            // TODO
            // 卖完票可以做其它事情，比如短信告知客户，邮件告诉客户等
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // 总共有15张票
        TicketService ticket = new TicketService(15);
        // 分3个窗口卖，每个窗口有10个人排队
        Window w1 = new Window("窗口1", 10);
        Window w2 = new Window("窗口2", 10);
        Window w3 = new Window("窗口3", 10);
        Thread t1 = new Thread(() -> w1.saleTicket(ticket), w1.name);
        Thread t2 = new Thread(() -> w2.saleTicket(ticket), w2.name);
        Thread t3 = new Thread(() -> w3.saleTicket(ticket), w3.name);
        t1.start();
        t2.start();
        t3.start();
    }

    static class Window {
        /**
         * 窗口的名称
         */
        public String name;
        /**
         * 排队的人数
         */
        private int persons;

        public Window(String name, int persons) {
            this.name = name;
            this.persons = persons;
        }

        public void saleTicket(TicketService ticketService) {
            for (int i = 0; i < persons; i++) {
                if (!ticketService.saleTicket()) {
                    System.out.println(Thread.currentThread().getName() + "系统无票可卖了，关闭窗口。");
                    break;
                }
            }
        }
    }
}
