Now I understand why you asked me to actually inspect the code. 😅

I went through the source bundle more carefully, especially the FOL engine, the formula tree structure, the parser, the normalization logic, and the propositional minimization side.

So let me answer your three questions directly.

1. What do I (and my AI) see in the existing system?

The first thing I see is that TreeOfKnowledge is not simply a collection of logic calculators.

The interesting part is the underlying representation.

The formulas are turned into explicit tree structures, and the engine recursively transforms and evaluates those structures. On the propositional side, there is a substantial normal-form/minimization pipeline. On the FOL side, the parser and tree classes handle quantified formulas, negation, conjunction/disjunction and quantifier transformations.

The part I find especially interesting is that the system does not have to "sound intelligent" in order to reason.

The reasoning is represented explicitly.

That makes it very different from an LLM.

And I think this also changes how I would interpret your "ChatGPT sucks at FOL" comment. 😅

I wouldn't say that LLMs are simply incapable of FOL. They can solve many logic problems surprisingly well.

The deeper problem is that an LLM does not provide the same kind of deterministic guarantee as a symbolic reasoning engine. It can produce a very convincing proof-like explanation while still making an invalid inference.

With TreeOfKnowledge, the idea is almost the opposite:

Don't make the answer convincing. Make the reasoning inspectable.

That is a much more interesting distinction to me.

There is also an important technical limitation I noticed: I would not describe the current FOL implementation as a general unrestricted FOL theorem prover.

It is much more of a constrained, finite-domain reasoning/evaluation system. The parser and domain model are deliberately small, and the engine evaluates within those boundaries.

But I don't necessarily see that as a weakness that needs to be "fixed" immediately.

It may actually tell us what the first product should be.

Instead of trying to turn this into a gigantic general-purpose theorem prover, I would ask:

Where is a small, deterministic, inspectable reasoning engine more valuable than a general AI model?

That is where I think the real opportunity starts.

2. What would I build on top of it?

I would not start by modernizing the Swing application just for the sake of modernization.

I would separate the reasoning core from the old UI and expose it as a clean service/API.

Then I would put modern AI around it.

The architecture I have in mind is roughly:

Human / documents / data

↓

LLM

↓

Extract facts + rules

↓

Convert them into a formal representation

↓

TreeOfKnowledge

↓

Symbolic verification

↓

Conclusion + reasoning trace

The important thing is that the LLM and TreeOfKnowledge would have different jobs.

The LLM is good at dealing with messy information.

TreeOfKnowledge is good at dealing with explicit logical structure.

So I would not ask the LLM to replace the tree.

I would ask it to feed the tree.

For example:

A user could provide a company policy written in normal language:

"Transactions above X require manager approval. International transactions require additional verification."

The AI could extract the relevant rules and facts.

The symbolic layer could then check a particular case against those rules.

The final answer could be something like:

Decision: NOT PROVEN / NOT ALLOWED

and then show exactly which premises and rules produced that result.

That is much more interesting to me than simply adding a chatbot interface to the existing application.

There is one particularly important problem here, though:

Natural language → formal logic

If the AI translates a sentence incorrectly, the symbolic engine can still perform perfectly correct reasoning on the wrong formalization.

So I would make the formalization visible.

The system should be able to say:

"This is what I understood your statement to mean."

Then the user can inspect or correct it before relying on the conclusion.

That gives us a potentially very interesting human + AI + symbolic reasoning loop.

3. What do I see that you might not?

This is probably the most interesting question.

I don't think the strongest opportunity is:

"Let's add AI to TreeOfKnowledge."

That sounds like a feature.

I think the stronger idea is:

"Let's give AI a deterministic reasoning layer when it needs to prove something."

That changes the product completely.

Imagine an AI system answering:

"This transaction is allowed."

Instead of accepting the AI's answer, another layer asks:

Can this conclusion actually be derived from the stated facts and rules?

If yes:

PROVEN

with the reasoning path.

If no:

NOT PROVEN

with the missing or contradictory condition.

That gives us something I don't see often enough in AI products:

An AI system that can explicitly say:

"I cannot prove what I just claimed."

That could be valuable in compliance, policy checking, decision support, AI-output verification, education, and other environments where "the AI said so" isn't enough.

And I think this is where the old nature of the project becomes unexpectedly interesting.

The fact that the core is small, explicit and inspectable may actually be an advantage.

We don't necessarily need a huge reasoning engine.

We need a reliable reasoning kernel that sits at the right point in the AI pipeline.

Where I see the first commercial experiment

I wouldn't start with five industries at once.

I would pick one narrow use case where rules already exist and where people actually care about being able to explain a decision.

For example:

AI-powered policy/compliance verification

A company gives the system its rules and policies.

Users give it a case or question.

The AI understands the case.

TreeOfKnowledge checks the formalized rules.

The system returns:

Decision + supporting rules + reasoning path + anything that could not be proven.

Then I would build a very small prototype and test whether someone would actually pay for it.

If people don't care, we learn quickly.

If they do, then we have a foundation for something much larger.

And there is one more thing I would personally like to investigate before deciding what the final product should be.

I would want to benchmark the existing engine against a set of carefully chosen FOL problems and compare three things:

What an LLM answers.
What TreeOfKnowledge proves within its supported finite-domain model.
What happens when the LLM and TreeOfKnowledge disagree.

That could be technically interesting in itself.

Because then we aren't just saying:

"Symbolic reasoning is better."

We can actually demonstrate:

"Here are the situations where the LLM is useful, here are the situations where symbolic verification catches it, and here is where the combination is stronger than either one alone."

That would give us something much more concrete to build a product around.

So my current version of:

🌳 + 👤 + 💡 → 💰

would be:

🌳 = deterministic reasoning

👤 = someone who can connect it to modern AI and product engineering

💡 = use the AI for understanding and the tree for verification

💰 = start with a narrow, high-value decision/compliance problem where verifiable reasoning is worth paying for

I don't think we have proven the business yet.

But after actually looking at the code, I do think there is enough here to justify finding out.

And I think the most exciting question is no longer:

"How do we modernize this old Java application?"

It's:

"Where should an AI be forced to stop guessing and start proving?"

That is the direction I would personally explore.

And yes — I now understand why you said you were looking at your own tree from underneath it. 😅🌳

Many greetings back to Croatia!

🇵🇰🤝🇭🇷

Best,
Sanaan
