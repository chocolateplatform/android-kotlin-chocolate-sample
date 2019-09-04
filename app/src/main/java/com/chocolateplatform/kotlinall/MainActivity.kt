package com.chocolateplatform.kotlinall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.vdopia.ads.lw.*
import com.vdopia.ads.lw.LVDOAdSize.IAB_MRECT

class MainActivity : AppCompatActivity(), InitCallback, LVDOInterstitialListener, RewardedAdListener, LVDOBannerAdListener, PrerollAdListener {

    var API_KEY = "XqjhRR"

    private lateinit var chocolateRewardedAd: LVDORewardedAd
    private lateinit var chocolateInterstitialAd: LVDOInterstitialAd
    private lateinit var chocolateInviewAd: LVDOBannerAd
    private lateinit var chocolatePrerollAd: PreRollVideoAd
    private lateinit var chocolateAdRequest: LVDOAdRequest
    private lateinit var adContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Chocolate.enableChocolateTestAds(true) //change to false when going live
        Chocolate.enableLogging(true) //change to false when going live
        chocolateAdRequest = LVDOAdRequest(this)
        Chocolate.init(this, API_KEY, chocolateAdRequest, this)

        chocolateInterstitialAd = LVDOInterstitialAd(this, this)
        chocolateRewardedAd = LVDORewardedAd(this, API_KEY, this)
        chocolateInviewAd = LVDOBannerAd(this, this)
        chocolatePrerollAd = PreRollVideoAd(this)
        adContainer = findViewById(R.id.adContainer)
    }

    fun loadInterstitialAd(view: View) {
        chocolateInterstitialAd.loadAd(chocolateAdRequest)
    }

    fun loadRewardedAd(view: View) {
        chocolateRewardedAd.loadAd(chocolateAdRequest)
    }

    fun loadInviewAd(view: View) {
        chocolateInviewAd.loadAd(chocolateAdRequest)
    }

    fun loadPrerollAd(view: View) {
        //Toast.makeText(this,"Preroll Ad feature coming soon...", Toast.LENGTH_SHORT).show()
        chocolatePrerollAd.visibility = View.VISIBLE
        chocolatePrerollAd.loadAd(chocolateAdRequest, LVDOAdSize.PRE_ROLL, this)
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
        Toast.makeText(this,"No-Fill for Native Inview Ad", Toast.LENGTH_SHORT).show()
    }

    override fun onPrerollAdClicked(p0: View?) {
    }

    override fun onPrerollAdFailed(p0: View?, p1: LVDOConstants.LVDOErrorCode?) {
        Toast.makeText(this,"No-Fill for Preroll Video Ad", Toast.LENGTH_SHORT).show()
    }

    override fun onPrerollAdShown(p0: View?) {
    }

    override fun onPrerollAdLoaded(view: View?) {
        adContainer.removeAllViews()
        adContainer.addView(view)
        chocolatePrerollAd.showAd()
    }

    override fun onPrerollAdCompleted(p0: View?) {
    }

    override fun onSuccess() {
    }

    override fun onError(p0: String?) {
    }

}
