/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class TLoop extends Token
{
    public TLoop()
    {
        super.setText("loop");
    }

    public TLoop(int line, int pos)
    {
        super.setText("loop");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLoop(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLoop(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLoop text.");
    }
}
