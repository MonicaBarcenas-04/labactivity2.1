package com.example.labactivity21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.labactivity21.databinding.FragmentMultipleChoiceBinding;

public class MultipleChoiceFragment extends Fragment {

    private FragmentMultipleChoiceBinding binding;
    private Question question;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMultipleChoiceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int questionIndex = (getArguments() != null) ? getArguments().getInt("questionIndex", 0) : 0;

        question = QuizRepository.getQuestion(questionIndex);
        binding.tvQuestionTitle.setText(question.getQuestionResId());

        View.OnClickListener listener = v -> {
            if (v instanceof Button) {
                String selectedPlanet = ((Button) v).getText().toString();
                checkAnswer(selectedPlanet);
            }
        };

        binding.btnMercury.setOnClickListener(listener);
        binding.btnVenus.setOnClickListener(listener);
        binding.btnEarth.setOnClickListener(listener);
        binding.btnMars.setOnClickListener(listener);
        binding.btnJupiter.setOnClickListener(listener);
        binding.btnSaturn.setOnClickListener(listener);
        binding.btnUranus.setOnClickListener(listener);
        binding.btnNeptune.setOnClickListener(listener);
    }

    private void checkAnswer(String selectedPlanet) {
        if (selectedPlanet.equalsIgnoreCase(question.getCorrectAnswer())) {
            String detailText = getString(question.getDetailResId());
            String result = getString(R.string.result_correct_format, detailText);
            binding.tvResult.setText(result);
        } else {
            binding.tvResult.setText(R.string.result_wrong);
        }
        binding.tvResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
