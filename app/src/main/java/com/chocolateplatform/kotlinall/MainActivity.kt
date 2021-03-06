package com.chocolateplatform.kotlinall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.vdopia.ads.lw.*
import com.vdopia.ads.lw.LVDOAdSize.MEDIUM_RECT_300_250

class MainActivity : AppCompatActivity(), InitCallback, LVDOInterstitialListener,
    RewardedAdListener, LVDOBannerAdListener, PrerollAdListener {

    var API_KEY = "XqjhRR"

    private lateinit var chocolateRewardedAd: LVDORewardedAd
    private lateinit var chocolateInterstitialAd: LVDOInterstitialAd
    private lateinit var chocolateBannerAd: LVDOBannerAd
    private lateinit var chocolateAdRequest: LVDOAdRequest
    private lateinit var chocolatePrerollAd: PreRollVideoAd
    private lateinit var adContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Chocolate.enableChocolateTestAds(true) //change to false when going live
        Chocolate.enableLogging(true) //change to false when going live
        chocolateAdRequest = LVDOAdRequest(this)
        Chocolate.init(this, API_KEY, chocolateAdRequest, this)

        chocolateInterstitialAd = LVDOInterstitialAd(this, this)
        chocolateRewardedAd = LVDORewardedAd(this, this)
        chocolateBannerAd = LVDOBannerAd(this, MEDIUM_RECT_300_250, this)
        chocolatePrerollAd = PreRollVideoAd(this);
        adContainer = findViewById(R.id.adContainer)
    }

    fun loadInterstitialAd(view: View) {
        chocolateInterstitialAd.loadAd(chocolateAdRequest)
    }

    fun loadRewardedAd(view: View) {
        chocolateRewardedAd.loadAd(chocolateAdRequest)
    }

    fun loadBannerAd(view: View) {
        chocolateBannerAd.loadAd(chocolateAdRequest)
    }

    fun loadPrerollAd(view: View) {
        chocolatePrerollAd.loadAd(chocolateAdRequest, LVDOAdSize.PREROLL_FULLSCREEN, this)
    }

    override fun onInterstitialLoaded(p0: LVDOInterstitialAd?) {
        chocolateInterstitialAd.show()
    }

    override fun onInterstitialShown(p0: LVDOInterstitialAd?) {
    }

    override fun onInterstitialFailed(p0: LVDOInterstitialAd?, p1: LVDOConstants.LVDOErrorCode?) {
        Toast.makeText(this,"No-Fill for Interstitial Ad", Toast.LENGTH_SHORT).show()
    }

    override fun onInterstitialDismissed(p0: LVDOInterstitialAd?) {
    }

    override fun onInterstitialClicked(p0: LVDOInterstitialAd?) {
    }

    override fun onRewardedVideoShownError(p0: LVDORewardedAd?, p1: LVDOConstants.LVDOErrorCode?) {
    }

    override fun onRewardedVideoCompleted(p0: LVDORewardedAd?) {
    }

    override fun onRewardedVideoFailed(p0: LVDORewardedAd?, p1: LVDOConstants.LVDOErrorCode?) {
        Toast.makeText(this,"No-Fill for Rewarded Ad", Toast.LENGTH_SHORT).show()
    }

    override fun onRewardedVideoDismissed(p0: LVDORewardedAd?) {
    }

    override fun onRewardedVideoLoaded(p0: LVDORewardedAd?) {
        chocolateRewardedAd.showRewardAd("my secret", "myuserid", "V-Bucks", "5000")
    }

    override fun onRewardedVideoShown(p0: LVDORewardedAd?) {
    }

    override fun onBannerAdClicked(p0: View?) {
    }

    override fun onBannerAdLoaded(view: View?) {
        adContainer.addView(view)
    }

    override fun onBannerAdClosed(p0: View?) {
    }

    override fun onBannerAdFailed(p0: View?, p1: LVDOConstants.LVDOErrorCode?) {
        Toast.makeText(this,"No-Fill for Banner Ad", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {
    }

    override fun onError(p0: String?) {
    }

    override fun onPrerollAdClicked(p0: View?) {
        //not implemented
    }

    override fun onPrerollAdShownError(p0: View?) {
        //not implemented
    }

    override fun onPrerollAdFailed(p0: View?, p1: LVDOConstants.LVDOErrorCode?) {
        //not implemented
    }

    override fun onPrerollAdShown(p0: View?) {
        //not implemented
    }

    override fun onPrerollAdLoaded(p0: View?) {
        //not implemented
    }

    override fun onPrerollAdCompleted(p0: View?) {
        //not implemented
    }
}
