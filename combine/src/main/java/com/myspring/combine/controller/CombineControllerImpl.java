package com.myspring.combine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.combine.service.CombineService;
import com.myspring.combine.vo.ScoreVO;





@Controller("combineController")
public class CombineControllerImpl implements CombineController {
    private static final int[] NUMBERS = {1, 2, 3};
    private static final int LENGTH = 3; 
    private static final int N = 9; 
    private static final int K = 3; 
    private List<List<Integer>> answer = new ArrayList<>();
    private Map<String, List<Integer>> map = new HashMap<>();
    private Set<Integer> trdNum = new HashSet<>();
    private List<List<Integer>> blocklist = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(CombineControllerImpl.class);

    @Autowired
    private CombineService combineService;

    @Autowired
    private ScoreVO scoreVO;

    @Override
    @RequestMapping(value = "/combine/score.do", method = RequestMethod.GET)
    public ModelAndView score(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        logger.debug("viewName = " + viewName);
        List<Object> scoresList = combineService.combineMembers();
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("scoresList", scoresList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/combine/game.do", method = RequestMethod.GET)
    public ModelAndView game(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        logger.debug("viewName = " + viewName);

        List<Object> scoresList = combineService.combineMembers();
        ModelAndView mav = new ModelAndView(viewName);
        newGame();

        Iterator<Integer> iter = trdNum.iterator();
        for (int i = 1; i < 10; i++) {
            String p = String.valueOf(i);
            int q = iter.next();
            String rq = String.valueOf(q - 1);
            mav.addObject("a" + p, rq);
        }
        mav.addObject("answer", answer);
        return mav;
    }

    public void newGame() {
        trdNum = new HashSet<>();
        Random random = new Random();
        generateCombinations(NUMBERS, LENGTH);
        while (trdNum.size() < 9) {
            int randomNumber = random.nextInt(27) + 1; // Generate a random number between 1 and 9
            trdNum.add(randomNumber);
        }
        Iterator<Integer> iter = trdNum.iterator();
        map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            String p = String.valueOf(i);
            int q = iter.next();
            String rq = String.valueOf(q);
            map.put(p, blocklist.get(q - 1));
        }
        for (int i = 1; i < 10; i++) {
            String p = String.valueOf(i);
            System.out.println(map.get(p));
        }
        System.out.println();
        List<List<Integer>> combinations = generateCombinations(N, K);

        answer = new ArrayList<>();
        for (List<Integer> combination : combinations) {
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            for (int cmb : combination) {
                String p = String.valueOf(cmb);
                List<Integer> tmpList = map.get(p);
                a1 += tmpList.get(0);
                a2 += tmpList.get(1);
                a3 += tmpList.get(2);
            }
            if (a1 % 3 == 0 && a2 % 3 == 0 && a3 % 3 == 0) {
                answer.add(combination);
            }
        }
        System.out.println(answer);
    }

    public void generateCombinations(int[] numbers, int length) {
        int[] combination = new int[length];
        generateCombinations(numbers, length, combination, 0);
    }

    private void generateCombinations(int[] numbers, int length, int[] combination, int current) {
        if (current == length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : combination) {
                tempList.add(num);
            }
            blocklist.add(tempList);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            combination[current] = numbers[i];
            generateCombinations(numbers, length, combination, current + 1);
        }
    }

    public static List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(n, k, 1, currentCombination, result);
        return result;
    }

    private static void generateCombinations(int n, int k, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            generateCombinations(n, k, i + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static boolean listsEqual(List<Integer> list1, List<Integer> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }

        if (list1 == null || list2 == null) {
            return false;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}
