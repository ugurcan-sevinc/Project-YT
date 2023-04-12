package com.ugrcaan.blogu

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ugrcaan.blogu.databinding.FragmentAuthHomeBinding

class AuthHomeFragment : Fragment() {
    private var _binding: FragmentAuthHomeBinding? = null
    private val binding get() = _binding!!

    private var animator: ValueAnimator? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthHomeBinding.inflate(inflater, container, false)

        // Start color change animation
        startColorChangeAnimation(binding.headerTV)

        return binding.root
    }

    private fun startColorChangeAnimation(textView: TextView) {
        val colorLight = ContextCompat.getColor(requireContext(), R.color.defaultHeaderTextColor_DarkStart)
        val colorDark = ContextCompat.getColor(requireContext(), R.color.defaultHeaderTextColor_DarkEnd)
        animator = ValueAnimator.ofArgb(colorLight, colorDark)
        animator?.duration = 2000
        animator?.repeatCount = ValueAnimator.INFINITE
        animator?.repeatMode = ValueAnimator.REVERSE
        animator?.addUpdateListener { animation ->
            val color = animation.animatedValue as Int
            textView.setTextColor(color)
        }
        animator?.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        animator?.cancel()
        animator = null
    }
}
