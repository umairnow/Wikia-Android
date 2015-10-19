package ciklum.umair.wikia.models;

import java.util.List;

/**
 * Created by umair1 on 10/13/15.
 */
public class WikisResponse {


    /**
     * items : [{"id":304,"name":"RuneScape Wiki","hub":"Gaming","language":"en","topic":null,"domain":"runescape.wikia.com"},{"id":410,"name":"Yu-Gi-Oh!","hub":"Gaming","language":"en","topic":null,"domain":"yugioh.wikia.com"},{"id":147,"name":"Wookieepedia","hub":"Entertainment","language":"en","topic":"Star Wars, ","domain":"starwars.wikia.com"},{"id":544934,"name":"WARFRAME Wiki","hub":"Gaming","language":"en","topic":null,"domain":"warframe.wikia.com"},{"id":3313,"name":"Riordan Wiki","hub":"Entertainment","language":"en","topic":null,"domain":"riordan.wikia.com"},{"id":3035,"name":"Fallout Wiki","hub":"Gaming","language":"en","topic":"Fallout, Fallout 2, Fallout 3, Fallout: New Vegas, Fallout Tactics, Brotherhood of Steel, Warfare, Fallout Trilogy","domain":"fallout.wikia.com"},{"id":691244,"name":"2007scape Wiki","hub":"Gaming","language":"en","topic":null,"domain":"2007.runescape.wikia.com"},{"id":1706,"name":"Elder Scrolls","hub":"Gaming","language":"en","topic":"Arena, Daggerfall, Morrowind, Oblivion, Skyrim","domain":"elderscrolls.wikia.com"},{"id":1318,"name":"Narutopedia","hub":"Entertainment","language":"en","topic":null,"domain":"naruto.wikia.com"},{"id":1081,"name":"One Piece Encyclopedia","hub":"Entertainment","language":"en","topic":null,"domain":"onepiece.wikia.com"},{"id":10150,"name":"Dragon Age Wiki","hub":"Gaming","language":"en","topic":"Dragon Age, Origins, Awakening, Dragon Age II","domain":"dragonage.wikia.com"},{"id":14764,"name":"League of Legends Wiki","hub":"Gaming","language":"en","topic":null,"domain":"leagueoflegends.wikia.com"},{"id":2233,"name":"Marvel Database","hub":null,"language":"en","topic":null,"domain":"marvel.wikia.com"},{"id":374,"name":"Disney Wiki","hub":"Entertainment","language":"en","topic":null,"domain":"disney.wikia.com"},{"id":841905,"name":"Brave Frontier Wiki","hub":"Gaming","language":"en","topic":null,"domain":"bravefrontierglobal.wikia.com"},{"id":13346,"name":"Walking Dead Wiki","hub":"Entertainment","language":"en","topic":null,"domain":"walkingdead.wikia.com"},{"id":2237,"name":"DC Database","hub":"Lifestyle","language":"en","topic":null,"domain":"dc.wikia.com"},{"id":490,"name":"WoWWiki","hub":"Gaming","language":"en","topic":"World of Warcraft, The Burning Crusade, Wrath of the Lich King, Cataclysm","domain":"wowwiki.wikia.com"},{"id":185111,"name":"Cardfight!! Vanguard Wiki","hub":"Creative","language":"en","topic":null,"domain":"cardfight.wikia.com"},{"id":530,"name":"Dragon Ball Wiki","hub":null,"language":"en","topic":null,"domain":"dragonball.wikia.com"},{"id":4541,"name":"GTA Wiki","hub":"Gaming","language":"en","topic":"GTA Wiki","domain":"gta.wikia.com"},{"id":634,"name":"Metal Gear Wiki","hub":"Gaming","language":"en","topic":"Metal Gear Wiki","domain":"metalgear.wikia.com"},{"id":509,"name":"Harry Potter Wiki","hub":"Entertainment","language":"en","topic":null,"domain":"harrypotter.wikia.com"},{"id":174,"name":"Final Fantasy Wiki","hub":"Gaming","language":"en","topic":null,"domain":"finalfantasy.wikia.com"},{"id":6276,"name":"Fairy Tail Wiki","hub":"Entertainment","language":"en","topic":null,"domain":"fairytail.wikia.com"}]
     * next : 25
     * total : 250
     * batches : 10
     * currentBatch : 1
     */

    private int next;
    private int total;
    private int batches;
    private int currentBatch;
    private List<WikiItem> items;

    public void setNext(int next) {
        this.next = next;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setBatches(int batches) {
        this.batches = batches;
    }

    public void setCurrentBatch(int currentBatch) {
        this.currentBatch = currentBatch;
    }

    public void setItems(List<WikiItem> items) {
        this.items = items;
    }

    public int getNext() {
        return next;
    }

    public int getTotal() {
        return total;
    }

    public int getBatches() {
        return batches;
    }

    public int getCurrentBatch() {
        return currentBatch;
    }

    public List<WikiItem> getItems() {
        return items;
    }

    public boolean isNextAvailable() {
        if (this.currentBatch == batches) {
            return false;
        }
        return true;
    }
}
