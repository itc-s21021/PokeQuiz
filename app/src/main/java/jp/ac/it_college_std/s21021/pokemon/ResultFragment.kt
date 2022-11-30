package jp.ac.it_college_std.s21021.pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import jp.ac.it_college_std.s21021.pokemon.databinding.FragmentQuestionBinding
import jp.ac.it_college_std.s21021.pokemon.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.returnbutton.setOnClickListener {
            Navigation.findNavController(it).navigate(
                ResultFragmentDirections.actionResultFragmentToGenerationFragment2()

            )
        }
        return binding.root
    }
}

